package bstu.pv.volobuev.CinemaSearch.business.service.impl;

import bstu.pv.volobuev.CinemaSearch.business.dao.MovieRepository;
import bstu.pv.volobuev.CinemaSearch.business.service.MovieService;
import bstu.pv.volobuev.CinemaSearch.business.utility.ImageDownloader;
import bstu.pv.volobuev.CinemaSearch.web.dto.ImageResponse;
import bstu.pv.volobuev.CinemaSearch.web.dto.contentPageDTO.MovieResponse;
import bstu.pv.volobuev.CinemaSearch.web.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final ImageDownloader imageDownloader;

    public MovieResponse getMovie(Long id){
        return movieMapper.toDTO(movieRepository.getMovieById(id));
    }

    @Override
    public ImageResponse getMoviePoster(Long id) {
        return imageDownloader.getImage(movieRepository.getMovieById(id).getPoster());
    }
}
