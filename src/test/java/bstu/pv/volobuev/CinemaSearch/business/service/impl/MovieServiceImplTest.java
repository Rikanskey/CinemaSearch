package bstu.pv.volobuev.CinemaSearch.business.service.impl;

import bstu.pv.volobuev.CinemaSearch.CinemaSearchApplication;
import bstu.pv.volobuev.CinemaSearch.business.entity.Movie;
import bstu.pv.volobuev.CinemaSearch.business.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest(classes = CinemaSearchApplication.class)
class MovieServiceImplTest {

    @Autowired
    private MovieService movieService;

    @Test
    void getMovieTest(){
        Movie movie = movieService.getMovie(1L);
        log.info("Movie countries: {}", movie.getCountries());
        assertNotNull(movie);
    }

    @Test
    void getMovieGenresTest(){
        Movie movie = movieService.getMovie(1L);
        assertEquals(2, movie.getGenres().size());
    }

}