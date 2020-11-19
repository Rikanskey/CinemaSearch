package bstu.pv.volobuev.CinemaSearch.controller;

import bstu.pv.volobuev.CinemaSearch.dto.contentPageDTO.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class ContentPageController {

      @GetMapping("/{id}")
      MovieResponse getMovie(@PathVariable Long id){
          MovieResponse movieResponse = new MovieResponse();

          movieResponse.setId(1L);
          movieResponse.setName("TENET");
          movieResponse.setPoster("https://images-na.ssl-images-amazon.com/images/I/71W2aEcrxxL._AC_SL1334_.jpg");

          movieResponse.setRelease(new GregorianCalendar(2020, Calendar.SEPTEMBER, 3));
          List<CountryResponse> countryResponses = new ArrayList<>();
          CountryResponse countryGreatBritain = new CountryResponse();
          countryGreatBritain.setId(1L);
          countryGreatBritain.setName("Great Britain");
          countryResponses.add(countryGreatBritain);
          CountryResponse countryUSA = new CountryResponse();
          countryUSA.setId(2L);
          countryUSA.setName("USA");
          countryResponses.add(countryUSA);
          movieResponse.setCountry(countryResponses);

          List<GenreResponse> genreResponses = new ArrayList<>();
          GenreResponse genreFantasy = new GenreResponse();
          genreFantasy.setId(1L);
          genreFantasy.setName("Fantasy");
          genreResponses.add(genreFantasy);
          GenreResponse genreAction = new GenreResponse();
          genreAction.setId(2L);
          genreAction.setName("Action");
          genreResponses.add(genreAction);
          movieResponse.setGenre(genreResponses);

          List<PersonResponse> directorResponses = new ArrayList<>();
          PersonResponse personChristopherNolan = new PersonResponse();
          personChristopherNolan.setId(1L);
          personChristopherNolan.setName("Christopher Nolan");
          directorResponses.add(personChristopherNolan);
          movieResponse.setDirector(directorResponses);

          List<PersonResponse> writerResponses = new ArrayList<>();
          writerResponses.add(personChristopherNolan);
          movieResponse.setWriter(writerResponses);

          List<PersonResponse> producerResponses = new ArrayList<>();
          PersonResponse personIvoFelt = new PersonResponse();
          personIvoFelt.setId(2L);
          personIvoFelt.setName("Ivo Felt");
          PersonResponse personThomasHayslip = new PersonResponse();
          personThomasHayslip.setId(3L);
          personThomasHayslip.setName("Thomas Hayslip");
          producerResponses.add(personChristopherNolan);
          producerResponses.add(personIvoFelt);
          producerResponses.add(personThomasHayslip);
          movieResponse.setProducer(producerResponses);

          List<PersonResponse> operatorResponses = new ArrayList<>();
          PersonResponse personHoyteVanHoytema = new PersonResponse();
          personHoyteVanHoytema.setId(4L);
          personHoyteVanHoytema.setName("Hoyte Van Hoytema");
          operatorResponses.add(personHoyteVanHoytema);
          movieResponse.setOperator(operatorResponses);

          List<PersonResponse> compositorResponses = new ArrayList<>();
          PersonResponse personLudwigGorannson = new PersonResponse();
          personLudwigGorannson.setId(5L);
          personLudwigGorannson.setName("Ludwig Gorannson");
          compositorResponses.add(personLudwigGorannson);
          movieResponse.setCompositor(compositorResponses);

          List<PersonResponse> actorResponses = new ArrayList<>();
          PersonResponse personJohnDavidWashington = new PersonResponse();
          personJohnDavidWashington.setId(6L);
          personJohnDavidWashington.setName("John David Washington");
          PersonResponse personRobertPattinson = new PersonResponse();
          personRobertPattinson.setId(7L);
          personRobertPattinson.setName("Robert Pattinson");
          PersonResponse personElizabethDebicki = new PersonResponse();
          personElizabethDebicki.setId(8L);
          personElizabethDebicki.setName("Elizabeth Debicki");
          actorResponses.add(personJohnDavidWashington);
          actorResponses.add(personRobertPattinson);
          actorResponses.add(personElizabethDebicki);
          movieResponse.setActor(actorResponses);

          movieResponse.setBudget(205000000L);
          movieResponse.setBox_office(300000000L);
          movieResponse.setDuration("2:30:00");
          movieResponse.setSynopsis("Armed with only one word—Tenet—and fighting for the survival of the entire" +
                  " world, the Protagonist journeys through a twilight world of international espionage on a mission" +
                  " that will unfold in something beyond real time.\n" +
                  "            Not time travel. Inversion.");
          movieResponse.setRating(8.5);
          movieResponse.setTrailer("https://www.youtube.com/embed/L3pk_TBkihU");
          return movieResponse;
      }
}
