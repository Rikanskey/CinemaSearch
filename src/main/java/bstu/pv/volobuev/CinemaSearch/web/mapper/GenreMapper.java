package bstu.pv.volobuev.CinemaSearch.web.mapper;

import bstu.pv.volobuev.CinemaSearch.business.entity.Genre;
import bstu.pv.volobuev.CinemaSearch.web.dto.contentPageDTO.GenreResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface GenreMapper extends GenericMapper<Genre, GenreResponse, GenreResponse> {
    GenreResponse toDTO(Genre genre);
    List<GenreResponse> toDTOs(Set<Genre> genres);
}
