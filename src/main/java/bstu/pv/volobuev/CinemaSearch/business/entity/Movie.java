package bstu.pv.volobuev.CinemaSearch.business.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.*;

@Entity(name = "movie")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String name;

    @NotNull
    Integer budget;

    @NotNull
    Integer box_office;

    @NotNull
    @Temporal(TemporalType.DATE)
    Date release;

    @NotNull
    Time duration;

    @NotNull
    String synopsis;

    @NotNull
    Double rating;

    @NotNull
    Integer rating_num;

    @NotNull
    String trailer_link;

    @NotNull
    String poster;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "movie_country",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "country_id", referencedColumnName = "id")

    )
    Set<Country> countries;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id")
            )
    Set<Genre> genres;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
            (
                    name = "person_post_movie",
                    joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
                    inverseJoinColumns = @JoinColumn(name = "person_post_id", referencedColumnName = "id")
            )
    List<PersonPost> personPosts;
}
