package bstu.pv.volobuev.CinemaSearch.web.controller;

import bstu.pv.volobuev.CinemaSearch.business.service.UserAccountService;
import bstu.pv.volobuev.CinemaSearch.web.dto.ImageResponse;
import bstu.pv.volobuev.CinemaSearch.web.dto.RequestRating;
import bstu.pv.volobuev.CinemaSearch.web.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserPageController {

    private final UserAccountService userAccountService;

    @GetMapping("/{id}")
    UserResponse getUser(@PathVariable Long id){
        return userAccountService.getUser(id);
    }

    @GetMapping("/{id}/avatar")
    public ResponseEntity<String> getUserAvatar(@PathVariable Long id){
        ImageResponse imageResponse = userAccountService.getUserAvatar(id);
        String encodeImage = Base64.getEncoder().encodeToString(imageResponse.getByteArrayResource().getByteArray());
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(300, TimeUnit.SECONDS))
                .contentLength(encodeImage.length())
                .contentType(imageResponse.getMediaType())
                .body(encodeImage);
    }

    @PostMapping("/{id}/avatar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void userUpdateAvatar(@PathVariable Long id, @RequestParam MultipartFile avatar){
        userAccountService.updateUserAvatar(id, avatar);
    }

    @GetMapping("/current")
    Long getUserByUsername(@RequestParam String username){
        return userAccountService.getUserIdByUsername(username);
    }

    @GetMapping("/movie/{id}/current_user")
    Long getUserMovieRating(Principal principal, @PathVariable Long id){
        return userAccountService.getUserMovieRating(principal, id);
    }

    @PutMapping("/movie/{id}")
    Double rateMovieByUser(@PathVariable Long id, @RequestBody RequestRating rating, Principal principal){
        log.info("{}, {}, {}", principal.getName(), id, rating);
        return userAccountService.rateMovie(principal, id, rating.getRating());
    }
}
