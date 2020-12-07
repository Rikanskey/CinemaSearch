package bstu.pv.volobuev.CinemaSearch.web.mapper.impl;

import bstu.pv.volobuev.CinemaSearch.business.entity.Movie;
import bstu.pv.volobuev.CinemaSearch.business.entity.PersonPost;
import bstu.pv.volobuev.CinemaSearch.web.dto.contentPageDTO.MovieResponse;
import bstu.pv.volobuev.CinemaSearch.web.mapper.*;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MovieMapperImpl implements MovieMapper {

    private final CountryMapper countryMapper;
    private final GenreMapper genreMapper;
    private final PersonMapper personMapper;

    public MovieResponse toDTO(Movie movie){
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setId(movie.getId());
        movieResponse.setName(movie.getName());
        movieResponse.setRelease(movie.getRelease());
        movieResponse.setCountry(countryMapper.toDTOs(movie.getCountries()));
        movieResponse.setGenre(genreMapper.toDTOs(movie.getGenres()));

        movieResponse.setDirector(personMapper.toDTOs(movie.getPersonPosts()
                .stream()
                .filter(
                        personPost -> personPost.getPost().getName().equals("director")
                )
                .map(PersonPost::getPerson)
                .collect(Collectors.toList())));

        movieResponse.setWriter(personMapper.toDTOs(movie.getPersonPosts()
                .stream()
                .filter(
                        personPost -> personPost.getPost().getName().equals("writer")
                )
                .map(PersonPost::getPerson)
                .collect(Collectors.toList())));

        movieResponse.setProducer(personMapper.toDTOs(movie.getPersonPosts()
                .stream()
                .filter(
                        personPost -> personPost.getPost().getName().equals("producer")
                )
                .map(PersonPost::getPerson)
                .collect(Collectors.toList())));

        movieResponse.setOperator(personMapper.toDTOs(movie.getPersonPosts()
                .stream()
                .filter(
                        personPost -> personPost.getPost().getName().equals("operator")
                )
                .map(PersonPost::getPerson)
                .collect(Collectors.toList())));

        movieResponse.setCompositor(personMapper.toDTOs(movie.getPersonPosts()
                .stream()
                .filter(
                        personPost -> personPost.getPost().getName().equals("compositor")
                )
                .map(PersonPost::getPerson)
                .collect(Collectors.toList())));

        movieResponse.setActor(personMapper.toDTOs(movie.getPersonPosts()
                .stream()
                .filter(
                        personPost -> personPost.getPost().getName().equals("actor")
                )
                .map(PersonPost::getPerson)
                .collect(Collectors.toList())));

        movieResponse.setBudget(movie.getBudget());
        movieResponse.setBox_office(movie.getBox_office());
        movieResponse.setDuration(movie.getDuration().toString());
        movieResponse.setSynopsis(movie.getSynopsis());
        movieResponse.setRating(movie.getRating());
        movieResponse.setTrailer(movie.getTrailer_link());
        movieResponse.setPoster(movie.getPoster()); //TODO: Not file path

        return movieResponse;
    }
}
