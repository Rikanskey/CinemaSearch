package bstu.pv.volobuev.CinemaSearch.business.service;

import bstu.pv.volobuev.CinemaSearch.web.dto.contentPageDTO.MovieResponse;

public interface MovieService {
    MovieResponse getMovie(Long id);
}
