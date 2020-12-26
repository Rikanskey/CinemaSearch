package bstu.pv.volobuev.CinemaSearch.business.service.impl;

import bstu.pv.volobuev.CinemaSearch.business.dao.AuthorityRepository;
import bstu.pv.volobuev.CinemaSearch.business.dao.MovieRepository;
import bstu.pv.volobuev.CinemaSearch.business.dao.UserRatingMovieRepository;
import bstu.pv.volobuev.CinemaSearch.business.dao.UserRepository;
import bstu.pv.volobuev.CinemaSearch.business.entity.Authority;
import bstu.pv.volobuev.CinemaSearch.business.entity.Movie;
import bstu.pv.volobuev.CinemaSearch.business.entity.UserAccount;
import bstu.pv.volobuev.CinemaSearch.business.entity.UserRatingMovie;
import bstu.pv.volobuev.CinemaSearch.business.service.UserAccountService;
import bstu.pv.volobuev.CinemaSearch.business.utility.ImageCreator;
import bstu.pv.volobuev.CinemaSearch.business.utility.ImageDownloader;
import bstu.pv.volobuev.CinemaSearch.business.utility.ObjectToUrlEncodedConverter;
import bstu.pv.volobuev.CinemaSearch.web.dto.*;
import bstu.pv.volobuev.CinemaSearch.web.mapper.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.*;


@RequiredArgsConstructor
@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserRepository userRepository;

    private final MovieRepository movieRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    private final AuthorityRepository authorityRepository;

    private final UserRatingMovieRepository userRatingMovieRepository;

    private final ImageDownloader imageDownloader;

    private final ImageCreator imageCreator;

    private final String avatarUsersDirectoryPath = "D:\\movie-library-images\\users-avatar\\";

    @Override
    public Boolean findUserByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Double rateMovie(Principal principal, Long movieId, Long rating) {
        UserAccount user = userRepository.getUserAccountByUsername(principal.getName()).get();
        Optional<UserRatingMovie> userRatingMovie =
                userRatingMovieRepository.getUserRatingMovieByMovieIdAndUserId(movieId, user.getId());
        Movie movie = movieRepository.getMovieById(movieId);
        if (userRatingMovie.isPresent()) {
            Long oldRating = userRatingMovie.get().getRating();

            userRatingMovie.get().setRating(rating);
            userRatingMovieRepository.save(userRatingMovie.get());

            movie.updateRatingWithExistUser(rating, oldRating);
        } else {
            user.rateMovie(movie, rating);
            userRepository.save(user);

            movie.setRating_num(movie.getRating_num() + 1);
            movie.updateRatingWithNewUser(rating);
        }
        movieRepository.save(movie);
        return movie.getRating();
    }

    @Override
    public UserResponse getUser(Long id){
        return userMapper.toDTO(userRepository.getUserAccountById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found")));
    }

    @Override
    public Long getUserIdByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userRepository.getUserAccountByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Username not found"));
        return userAccount.getId();
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Long getUserMovieRating(Principal principal, Long movieId) {
        UserAccount user = userRepository.getUserAccountByUsername(principal.getName()).get();
        Optional<UserRatingMovie> userRatingMovie =
                userRatingMovieRepository.getUserRatingMovieByMovieIdAndUserId(movieId, user.getId());
        return userRatingMovie.isPresent() ? userRatingMovie.get().getRating() : 0L;
    }

    @Override
    public ImageResponse getUserAvatar(Long id){
        return imageDownloader.getImage(userRepository.getUserAccountById(id).get().getAvatar());
    }

    @Override
    public void updateUserAvatar(Long id, MultipartFile multipartFile) {
        UserAccount userAccount = userRepository.getUserAccountById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        String avatarFilename = userAccount.getUsername() + "-avatar." + multipartFile.getContentType()
                .split("/")[1];
        imageCreator.createImage(avatarUsersDirectoryPath + avatarFilename, multipartFile);
        userAccount.setAvatar(avatarUsersDirectoryPath + avatarFilename);
        userRepository.save(userAccount);
    }

    @Override
    public boolean registrationUser(UserRegistrationRequest userRegistrationRequest) {
        if (!userRepository.existsByUsername(userRegistrationRequest.getUsername())){
            userRepository.save(createUser(userRegistrationRequest));
            return true;
        }
        return false;
    }

    private UserAccount createUser(UserRegistrationRequest userRegistrationRequest){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(userRegistrationRequest.getUsername());
        userAccount.setPassword(passwordEncoder.encode(userRegistrationRequest.getPassword()));
        Authority authority = authorityRepository.getAuthorityByName("ROLE_USER");
        Set<Authority> authorities = new HashSet<>();
        authorities.add(authority);
        userAccount.setAuthorities(authorities);
        userAccount.setEnabled(true);
        userAccount.setAccountNonLocked(true);
        userAccount.setAccountNonExpired(true);
        userAccount.setCredentialsNonExpired(true);
        userAccount.setAvatar(avatarUsersDirectoryPath + "user-unknown-avatar.jpg");
        return userAccount;
    }

    @Override
    public AuthorizationToken authenticationUser(RequestAuth requestAuth, String authorization) {
        String uri = "http://localhost:8082/oauth/token";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new ObjectToUrlEncodedConverter(new ObjectMapper()));
        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(createBody(requestAuth), createHeaders(authorization));
        return restTemplate.postForObject(uri, request , AuthorizationToken.class);
    }

    private HttpHeaders createHeaders(String authorization){
            HttpHeaders headers = new HttpHeaders();
            headers.setBasicAuth(authorization.split(" ")[1]);
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            return headers;
    }

    private Map<String, Object> createBody(RequestAuth requestAuth){
        Map<String, Object> bodyRequest = new HashMap<>();
        bodyRequest.put("grant_type", requestAuth.getGrant_type());
        bodyRequest.put("username", requestAuth.getUsername());
        bodyRequest.put("password", requestAuth.getPassword());
        return bodyRequest;
    }
}
