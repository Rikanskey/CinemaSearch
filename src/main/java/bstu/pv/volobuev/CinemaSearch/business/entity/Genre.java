package bstu.pv.volobuev.CinemaSearch.business.entity;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "genre")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Genre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String name;

    @ManyToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Set<Movie> movies;
}
