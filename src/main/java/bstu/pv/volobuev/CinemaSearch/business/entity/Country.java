package bstu.pv.volobuev.CinemaSearch.business.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "country")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany
    Set<Movie> movies;
}
