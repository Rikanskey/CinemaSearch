package bstu.pv.volobuev.CinemaSearch.business.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "post")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String name;

    @OneToMany(mappedBy = "post")
    Set<PersonPost> personPosts;
}
