package bstu.pv.volobuev.CinemaSearch.business.service.impl;

import bstu.pv.volobuev.CinemaSearch.business.dao.MovieRepository;
import bstu.pv.volobuev.CinemaSearch.business.entity.Movie;
import bstu.pv.volobuev.CinemaSearch.business.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;


    public Movie getMovie(Long id){
        return movieRepository.getMovieById(id);
    }
}
