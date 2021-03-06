package bstu.pv.volobuev.CinemaSearch.web.dto.contentPageDTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.GregorianCalendar;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MovieResponse {
    Long id;
    String name;
    GregorianCalendar release;
    List<CountryResponse> country;
    List<GenreResponse> genre;
    List<PersonResponse> director;
    List<PersonResponse> writer;
    List<PersonResponse> producer;
    List<PersonResponse> operator;
    List<PersonResponse> compositor;
    List<PersonResponse> actor;
    Long budget;
    Long box_office;
    String duration;
    String synopsis;
    Double rating;
    String trailer;
}
