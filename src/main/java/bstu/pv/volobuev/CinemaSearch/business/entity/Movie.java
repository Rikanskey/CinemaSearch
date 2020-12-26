package bstu.pv.volobuev.CinemaSearch.business.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Time;
import java.util.*;

@Entity(name = "movie")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @ToString.Include
    String name;

    @NotNull
    Long budget;

    @NotNull
    Long box_office;

    @NotNull
    GregorianCalendar release;

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

    @ManyToMany
    @JoinTable(
            name = "movie_country",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "country_id", referencedColumnName = "id")

    )
    Set<Country> countries;

    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id")
            )
    Set<Genre> genres;

    @ManyToMany
    @JoinTable
            (
                    name = "person_post_movie",
                    joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
                    inverseJoinColumns = @JoinColumn(name = "person_post_id", referencedColumnName = "id")
            )
    Set<PersonPost> personPosts;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    Set<UserRatingMovie> usersRating;

    public void updateRatingWithNewUser(Long userRating){
        rating = (rating * (rating_num - 1) + userRating) / rating_num;
    }

    public void updateRatingWithExistUser(Long userRating, Long oldRating){
        rating = (rating * rating_num - oldRating + userRating) / rating_num;
    }
}
