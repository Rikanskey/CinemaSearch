package bstu.pv.volobuev.CinemaSearch.business.service;

import bstu.pv.volobuev.CinemaSearch.web.dto.MainPageMoviePosterResponse;

import java.util.List;

public interface MainPageService {
    List<MainPageMoviePosterResponse> getMoviePosters();

    Long getRandomMovieId();
}
