package bstu.pv.volobuev.CinemaSearch.dto.contentPageDTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.GregorianCalendar;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MovieResponse {
    Long id;
    String name;
    String poster;
    GregorianCalendar release;
    List<CountryResponse> country;
    List<GenreResponse> genre;
    List<PersonResponse> director;
    List<PersonResponse> writer;
    List<PersonResponse> producer;
    List<PersonResponse> operator;
    List<PersonResponse> compositor;
    List<PersonResponse> actor;
    Long budget;
    Long box_office;
    String duration;
    String synopsis;
    Double rating;
    String trailer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public GregorianCalendar getRelease() {
        return release;
    }

    public void setRelease(GregorianCalendar release) {
        this.release = release;
    }

    public List<CountryResponse> getCountry() {
        return country;
    }

    public void setCountry(List<CountryResponse> country) {
        this.country = country;
    }

    public List<GenreResponse> getGenre() {
        return genre;
    }

    public void setGenre(List<GenreResponse> genre) {
        this.genre = genre;
    }

    public List<PersonResponse> getDirector() {
        return director;
    }

    public void setDirector(List<PersonResponse> director) {
        this.director = director;
    }

    public List<PersonResponse> getWriter() {
        return writer;
    }

    public void setWriter(List<PersonResponse> writer) {
        this.writer = writer;
    }

    public List<PersonResponse> getProducer() {
        return producer;
    }

    public void setProducer(List<PersonResponse> producer) {
        this.producer = producer;
    }

    public List<PersonResponse> getOperator() {
        return operator;
    }

    public void setOperator(List<PersonResponse> operator) {
        this.operator = operator;
    }

    public List<PersonResponse> getCompositor() {
        return compositor;
    }

    public void setCompositor(List<PersonResponse> compositor) {
        this.compositor = compositor;
    }

    public List<PersonResponse> getActor() {
        return actor;
    }

    public void setActor(List<PersonResponse> actor) {
        this.actor = actor;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Long getBox_office() {
        return box_office;
    }

    public void setBox_office(Long box_office) {
        this.box_office = box_office;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
}
