package bstu.pv.volobuev.CinemaSearch.business.service.impl;

import bstu.pv.volobuev.CinemaSearch.CinemaSearchApplication;
import bstu.pv.volobuev.CinemaSearch.business.dao.UserRatingMovieRepository;
import bstu.pv.volobuev.CinemaSearch.business.dao.UserRepository;
import bstu.pv.volobuev.CinemaSearch.business.entity.UserAccount;
import bstu.pv.volobuev.CinemaSearch.business.service.UserAccountService;
import bstu.pv.volobuev.CinemaSearch.web.dto.UserRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest(classes = CinemaSearchApplication.class)
class UserAccountServiceImplTest {

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRatingMovieRepository userRatingMovieRepository;

    @Test
    void findUserByUsernameTest() {
        Boolean result = userAccountService.findUserByUsername("testuser");
        log.info("Result: {}", result);
        assertTrue(result);
    }

    @Test
    void encoderTest(){
        String password = "client123";
        String firstEncode = passwordEncoder.encode(password);
        String secondEncode = passwordEncoder.encode(password);
        log.info("First password: {}; Second password: {}", firstEncode, secondEncode);
        assertNotEquals(firstEncode, secondEncode);
    }

    @Test
    void equalsUsernamePasswordRequestAndDB() {
        UserRegistrationRequest user = new UserRegistrationRequest();
        user.setUsername("testuser");
        user.setPassword("test123");
        userRepository.getUserAccountByUsername("testuser")
                .ifPresent(userAccount -> assertTrue(passwordEncoder.matches(user.getPassword(),
                        userAccount.getPassword())));

    }

    @Test
    void authManagerUsernamePasswordRequest(){
        UserRegistrationRequest user = new UserRegistrationRequest();
        user.setUsername("testuser");
        user.setPassword("test123");
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getUsername(), user.getPassword(), new ArrayList<>()));
            log.info("Successful!");
        } catch (AuthenticationException e){
            log.info("Failed, {}", e.getMessage());
        }
        String cl = "client123";
        String cll = "cinema-search-client";
        String enc = passwordEncoder.encode(cl);
        log.info("client123 {}\nclient-name {}\nEnc {}\nDecode {}",
                Base64.getEncoder().encodeToString(cl.getBytes(StandardCharsets.UTF_8)),
                Base64.getEncoder().encodeToString(cll.getBytes(StandardCharsets.UTF_8)),
                enc,
                Base64.getDecoder().decode("Y2luZW1hLXNlYXJjaC1jbGllbnQ6Y2xpZW50MTIz"));
    }

    @Test
    public void getMovieRatingUser(){
        Long rating = userRatingMovieRepository.getUserRatingMovieByMovieIdAndUserId(1L, 1L).get()
                .getRating();
        log.info("{}", rating);
        assertEquals(8, rating);
    }

    @Test
    public void getUserById(){
        UserAccount user = userRepository.getUserAccountById(1L).get();
        log.info("{}", user.getMovie());
        assertEquals(4, user.getMovie().size());
    }
}