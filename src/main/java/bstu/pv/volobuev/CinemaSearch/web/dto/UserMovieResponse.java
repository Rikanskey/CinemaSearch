package bstu.pv.volobuev.CinemaSearch.web.dto;

import bstu.pv.volobuev.CinemaSearch.web.dto.contentPageDTO.MovieResponse;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserMovieResponse {
    Long id;
    String name;
}
