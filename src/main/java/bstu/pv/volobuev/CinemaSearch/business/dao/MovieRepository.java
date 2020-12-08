package bstu.pv.volobuev.CinemaSearch.business.dao;

import bstu.pv.volobuev.CinemaSearch.business.entity.Movie;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie getMovieById(Long id);

    List<Movie> getAllBy(Sort sort);

    Long countMovieBy();
}
