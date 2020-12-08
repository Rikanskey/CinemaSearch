package bstu.pv.volobuev.CinemaSearch.web.mapper;

import bstu.pv.volobuev.CinemaSearch.business.entity.Movie;
import bstu.pv.volobuev.CinemaSearch.web.dto.MainPageMoviePosterResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MainPageMapper extends GenericMapper<Movie, MainPageMoviePosterResponse, MainPageMoviePosterResponse> {
    List<MainPageMoviePosterResponse> toDTOs(List<Movie> movies);
}
