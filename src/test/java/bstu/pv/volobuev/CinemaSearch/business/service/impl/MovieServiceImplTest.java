package bstu.pv.volobuev.CinemaSearch.business.service.impl;

import bstu.pv.volobuev.CinemaSearch.CinemaSearchApplication;
import bstu.pv.volobuev.CinemaSearch.business.dao.MovieRepository;
import bstu.pv.volobuev.CinemaSearch.business.service.MovieService;
import bstu.pv.volobuev.CinemaSearch.web.dto.contentPageDTO.MovieResponse;
import bstu.pv.volobuev.CinemaSearch.web.mapper.MovieMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
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
        MovieResponse movieResponse = movieService.getMovie(1L);
        log.info("Movie response {}", movieResponse);
        assertNotNull(movieResponse);
    }

}