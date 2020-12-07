package bstu.pv.volobuev.CinemaSearch.business.service.impl;

import bstu.pv.volobuev.CinemaSearch.CinemaSearchApplication;
import bstu.pv.volobuev.CinemaSearch.business.dao.MovieRepository;
import bstu.pv.volobuev.CinemaSearch.business.entity.*;
import bstu.pv.volobuev.CinemaSearch.business.service.MovieService;
import bstu.pv.volobuev.CinemaSearch.web.dto.contentPageDTO.MovieResponse;
import bstu.pv.volobuev.CinemaSearch.web.mapper.MovieMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.sql.Time;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest(classes = CinemaSearchApplication.class)
class MovieServiceImplTest {

    private MovieService movieService;

    @Mock
    private MovieRepository movieRepository;

    @Autowired
    private MovieMapper movieMapper;

    @BeforeEach
    void setUp(){
        movieService = new MovieServiceImpl(movieRepository, movieMapper);
    }

    @Test
    void getMovieTest(){
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setName("Tenet");
        movie.setBudget(205000000L);
        movie.setBox_office(300000000L);
        movie.setRelease(new GregorianCalendar(2020, Calendar.SEPTEMBER, 3));
        movie.setDuration(new Time(2, 30, 0));
        movie.setSynopsis("Armed with only one word—Tenet—and fighting for the survival of the entire world, the Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.\n" +
                "\n" +
                "Not time travel. Inversion.");
        movie.setRating(8.6);
        movie.setTrailer_link("https://youtu.be/L3pk_TBkihU");

        Set<Country> countries = new HashSet<>();
        Country country1 = new Country();
        country1.setId(1L);
        country1.setName("Great Britain");
        Country country2 = new Country();
        country2.setId(2L);
        country2.setName("USA");
        countries.add(country1);
        countries.add(country2);
        movie.setCountries(countries);

        Set<Genre> genres = new HashSet<>();
        Genre genre1 = new Genre();
        genre1.setId(1L);
        genre1.setName("Fantasy");
        Genre genre2 = new Genre();
        genre2.setId(2L);
        genre2.setName("Action");
        genres.add(genre1);
        genres.add(genre2);
        movie.setGenres(genres);

        Person person1 = new Person();
        person1.setId(1L);
        person1.setName("Christopher Nolan");
        Person person2 = new Person();
        person2.setId(2L);
        person2.setName("Ivo Felt");
        Person person3 = new Person();
        person3.setId(3L);
        person3.setName("Thomas Hayslip");
        Person person4 = new Person();
        person4.setId(4L);
        person4.setName("Emma Thomas");
        Person person5 = new Person();
        person5.setId(5L);
        person5.setName("Hoyte Van Hoytema");
        Person person6 = new Person();
        person6.setId(6L);
        person6.setName("Ludwig Goransson");
        Person person7 = new Person();
        person7.setId(7L);
        person7.setName("John David Washington");
        Person person8 = new Person();
        person8.setId(8L);
        person8.setName("Robert Pattinson");
        Person person9 = new Person();
        person9.setId(9L);
        person9.setName("Elizabeth Debicki");

        Post post1 = new Post();
        post1.setId(1L);
        post1.setName("director");
        Post post2 = new Post();
        post2.setId(2L);
        post2.setName("writer");
        Post post3 = new Post();
        post3.setId(3L);
        post3.setName("producer");
        Post post4 = new Post();
        post4.setId(4L);
        post4.setName("operator");
        Post post5 = new Post();
        post5.setId(5L);
        post5.setName("compositor");
        Post post6 = new Post();
        post6.setId(6L);
        post6.setName("actor");

        PersonPost personPost1 = new PersonPost();
        personPost1.setId(1L);
        personPost1.setPerson(person1);
        personPost1.setPost(post1);
        PersonPost personPost2 = new PersonPost();
        personPost2.setId(2L);
        personPost2.setPerson(person1);
        personPost2.setPost(post2);
        PersonPost personPost3 = new PersonPost();
        personPost3.setId(3L);
        personPost3.setPerson(person2);
        personPost3.setPost(post3);
        PersonPost personPost4 = new PersonPost();
        personPost4.setId(4L);
        personPost4.setPerson(person3);
        personPost4.setPost(post3);
        PersonPost personPost5 = new PersonPost();
        personPost5.setId(5L);
        personPost5.setPerson(person1);
        personPost5.setPost(post3);
        PersonPost personPost6 = new PersonPost();
        personPost6.setId(6L);
        personPost6.setPerson(person4);
        personPost6.setPost(post3);
        PersonPost personPost7 = new PersonPost();
        personPost7.setId(7L);
        personPost7.setPerson(person5);
        personPost7.setPost(post4);
        PersonPost personPost8 = new PersonPost();
        personPost8.setId(8L);
        personPost8.setPerson(person6);
        personPost8.setPost(post5);
        PersonPost personPost9 = new PersonPost();
        personPost9.setId(9L);
        personPost9.setPerson(person7);
        personPost9.setPost(post6);
        PersonPost personPost10 = new PersonPost();
        personPost10.setId(10L);
        personPost10.setPerson(person8);
        personPost10.setPost(post6);
        PersonPost personPost11 = new PersonPost();
        personPost11.setId(11L);
        personPost11.setPerson(person9);
        personPost11.setPost(post6);
        List<PersonPost> personPosts = new ArrayList<>();
        personPosts.add(personPost1);
        personPosts.add(personPost2);
        personPosts.add(personPost3);
        personPosts.add(personPost4);
        personPosts.add(personPost5);
        personPosts.add(personPost6);
        personPosts.add(personPost7);
        personPosts.add(personPost8);
        personPosts.add(personPost9);
        personPosts.add(personPost10);
        personPosts.add(personPost11);
        movie.setPersonPosts(personPosts);
        Mockito.when(movieRepository.getMovieById(1L)).thenReturn(movie);
        MovieResponse movieResponse = movieService.getMovie(1L);
        log.info("Movie response {}", movieResponse);
        assertNotNull(movieResponse);
    }

}