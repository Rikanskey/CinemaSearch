package bstu.pv.volobuev.CinemaSearch.business.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "country")
@Getter
@Setter
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@ToString(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String name;

//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
    @ManyToMany
    Set<Movie> movies;
}
