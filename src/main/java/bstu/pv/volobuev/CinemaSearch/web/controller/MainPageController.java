package bstu.pv.volobuev.CinemaSearch.web.controller;

import bstu.pv.volobuev.CinemaSearch.business.service.MainPageService;
import bstu.pv.volobuev.CinemaSearch.web.dto.MainPageMoviePosterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainPageController {

    private final MainPageService mainPageService;

    @GetMapping
    List<MainPageMoviePosterResponse> getMoviesTopFive(){
        return mainPageService.getMoviePosters();
    }

    @GetMapping("/random")
    Long getRandomMovieID(){
        return mainPageService.getRandomMovieId();
    }
}
