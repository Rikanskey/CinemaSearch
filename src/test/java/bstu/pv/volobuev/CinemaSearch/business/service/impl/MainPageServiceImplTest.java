package bstu.pv.volobuev.CinemaSearch.business.service.impl;

import bstu.pv.volobuev.CinemaSearch.CinemaSearchApplication;

import bstu.pv.volobuev.CinemaSearch.business.service.MainPageService;
import bstu.pv.volobuev.CinemaSearch.web.dto.MainPageMoviePosterResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@SpringBootTest(classes = CinemaSearchApplication.class)
class MainPageServiceImplTest {

    @Autowired
    private MainPageService mainPageService;

    @Test
    public void getMoviesWithRating(){
        List<MainPageMoviePosterResponse> movies = mainPageService.getMoviePosters();
        log.info("{}", movies);
        assertEquals(5, movies.size());
    }

    @Test
    public void getRandomMovieId(){
        Long id = mainPageService.getRandomMovieId();
        log.info("{}", id);
        assertNotNull(id);
    }

    @Test
    public void getRandomMovieIdDoesntContainZero(){
        Set<Long> experimental = new HashSet<>();
        for (int i = 0; i < 10; i++)
            experimental.add(mainPageService.getRandomMovieId());
        log.info("Experiment results {}", experimental);
        assertFalse(experimental.contains(0L));
    }
}