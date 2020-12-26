package bstu.pv.volobuev.CinemaSearch.business.dao;

import bstu.pv.volobuev.CinemaSearch.business.entity.UserRatingMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRatingMovieRepository extends JpaRepository<UserRatingMovie, Long> {
    Optional<UserRatingMovie> getUserRatingMovieByMovieIdAndUserId(Long movieId, Long userId);
}
