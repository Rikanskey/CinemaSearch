package bstu.pv.volobuev.CinemaSearch.business.service;

import bstu.pv.volobuev.CinemaSearch.web.dto.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

public interface UserAccountService {
    Boolean findUserByUsername(String username);

    Double rateMovie(Principal principal, Long movieId, Long rating);

    UserResponse getUser(Long id);

    boolean registrationUser(UserRegistrationRequest userRegistrationRequest);

    AuthorizationToken authenticationUser(RequestAuth requestAuth, String authorization);

    Long getUserIdByUsername(String username);

    Long getUserMovieRating(Principal principal, Long movieId);

    ImageResponse getUserAvatar(Long id);

    void updateUserAvatar(Long id, MultipartFile multipartFile);
}
