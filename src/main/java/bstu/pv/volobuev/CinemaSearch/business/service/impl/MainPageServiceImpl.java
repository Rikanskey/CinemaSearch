package bstu.pv.volobuev.CinemaSearch.business.service.impl;

import bstu.pv.volobuev.CinemaSearch.business.dao.MovieRepository;
import bstu.pv.volobuev.CinemaSearch.business.service.MainPageService;
import bstu.pv.volobuev.CinemaSearch.web.dto.MainPageMoviePosterResponse;
import bstu.pv.volobuev.CinemaSearch.web.mapper.MainPageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MainPageServiceImpl implements MainPageService {

    private final MovieRepository movieRepository;

    private final MainPageMapper mainPageMapper;

    public List<MainPageMoviePosterResponse> getMoviePosters() {
        return mainPageMapper.toDTOs(movieRepository.getAllBy(Sort.by(Sort.Direction.DESC, "rating"))
                .stream().limit(5).collect(Collectors.toList()));
    }

    public Long getRandomMovieId() {
        Long countOfMovie = movieRepository.countMovieBy();
        Random random = new Random();
        return (long) random.nextInt(countOfMovie.intValue())+1;
    }
}
