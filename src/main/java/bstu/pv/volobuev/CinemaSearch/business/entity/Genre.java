package bstu.pv.volobuev.CinemaSearch.business.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "genre")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String name;

    @ManyToMany
    Set<Movie> movies;
}
