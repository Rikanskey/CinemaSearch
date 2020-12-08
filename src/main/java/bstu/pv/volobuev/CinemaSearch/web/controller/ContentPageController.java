package bstu.pv.volobuev.CinemaSearch.web.controller;

import bstu.pv.volobuev.CinemaSearch.business.service.MovieService;
import bstu.pv.volobuev.CinemaSearch.web.dto.contentPageDTO.CountryResponse;
import bstu.pv.volobuev.CinemaSearch.web.dto.contentPageDTO.GenreResponse;
import bstu.pv.volobuev.CinemaSearch.web.dto.contentPageDTO.MovieResponse;
import bstu.pv.volobuev.CinemaSearch.web.dto.contentPageDTO.PersonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movie")
public class ContentPageController {

    private final MovieService movieService;

      @GetMapping("/{id}")
      MovieResponse getMovie(@PathVariable Long id){
          return movieService.getMovie(id);
      }
}
