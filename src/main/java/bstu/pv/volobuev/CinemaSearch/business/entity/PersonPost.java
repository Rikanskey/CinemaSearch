package bstu.pv.volobuev.CinemaSearch.business.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity(name = "person_post")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonPost implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    Person person;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    Post post;

    @ManyToMany(mappedBy = "personPosts")
    Set<Movie> movies;
}
