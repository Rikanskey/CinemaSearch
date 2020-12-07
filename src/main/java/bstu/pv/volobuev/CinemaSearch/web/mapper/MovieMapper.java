package bstu.pv.volobuev.CinemaSearch.web.mapper;

import bstu.pv.volobuev.CinemaSearch.business.entity.Movie;
import bstu.pv.volobuev.CinemaSearch.web.dto.MovieRequest;
import bstu.pv.volobuev.CinemaSearch.web.dto.contentPageDTO.MovieResponse;
import org.springframework.stereotype.Component;


@Component
public interface MovieMapper extends GenericMapper<Movie, MovieResponse, MovieRequest> {
    MovieResponse toDTO(Movie movie);
}
