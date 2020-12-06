package bstu.pv.volobuev.CinemaSearch.business.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "country")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String name;

    @ManyToMany
    Set<Movie> movies;
}
