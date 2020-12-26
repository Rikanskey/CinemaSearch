package bstu.pv.volobuev.CinemaSearch.business.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

@Entity(name = "person")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @OneToMany(mappedBy = "person")
    Set<PersonPost> personPosts;

}
