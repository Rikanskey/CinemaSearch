package bstu.pv.volobuev.CinemaSearch.web.controller;

import bstu.pv.volobuev.CinemaSearch.business.service.MovieService;
import bstu.pv.volobuev.CinemaSearch.web.dto.ImageResponse;
import bstu.pv.volobuev.CinemaSearch.web.dto.contentPageDTO.MovieResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movie")
@Slf4j
public class ContentPageController {

    private final MovieService movieService;

    @GetMapping("/{id}")
    MovieResponse getMovie(@PathVariable Long id){
          return movieService.getMovie(id);
      }

    @GetMapping("/{id}/img")
    ResponseEntity<String> getMoviePoster(@PathVariable Long id){
        ImageResponse imageResponse = movieService.getMoviePoster(id);
        String encodeImage = Base64.getEncoder().encodeToString(imageResponse.getByteArrayResource().getByteArray());
        return ResponseEntity
                .ok()
                .cacheControl(CacheControl.maxAge(300, TimeUnit.SECONDS))
                .contentLength(encodeImage.length())
                .contentType(imageResponse.getMediaType())
                .body(encodeImage);
    }
}
