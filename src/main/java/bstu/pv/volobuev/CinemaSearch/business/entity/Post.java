package bstu.pv.volobuev.CinemaSearch.business.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "post")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String name;

    @OneToMany(mappedBy = "post")
    Set<PersonPost> personPosts;
}
