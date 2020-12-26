package bstu.pv.volobuev.CinemaSearch.web.controller;

import bstu.pv.volobuev.CinemaSearch.business.service.UserAccountService;
import bstu.pv.volobuev.CinemaSearch.web.dto.AuthorizationToken;
import bstu.pv.volobuev.CinemaSearch.web.dto.RequestAuth;
import bstu.pv.volobuev.CinemaSearch.web.dto.UserRegistrationRequest;
import bstu.pv.volobuev.CinemaSearch.web.dto.UsernameAjaxRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthorizationRegistrationPage {

    private final UserAccountService userAccountService;

    @PostMapping("/registration/ajax")
    Boolean authorizationUser(@RequestBody UsernameAjaxRequest username){
        Boolean exist = userAccountService.findUserByUsername(username.getUsername());
        log.info("User {} is {}", username, exist);
        return exist;
    }

    @PostMapping("/registration")
    ResponseEntity<Boolean> registrationUser(@RequestBody UserRegistrationRequest userRegistrationRequest){
        return ResponseEntity.ok().body(userAccountService.registrationUser(userRegistrationRequest));
    }

    @PostMapping( "/request")
    ResponseEntity<AuthorizationToken> authorizationRequest(RequestAuth requestAuth,
                                                            @RequestHeader String authorization){
        log.info("{}, {}", requestAuth, authorization);
        return ResponseEntity.ok().body(userAccountService.authenticationUser(requestAuth, authorization));
    }
}
