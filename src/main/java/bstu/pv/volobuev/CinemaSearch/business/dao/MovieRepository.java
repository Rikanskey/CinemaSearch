package bstu.pv.volobuev.CinemaSearch.business.dao;

import bstu.pv.volobuev.CinemaSearch.business.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie getMovieById(Long id);
}
