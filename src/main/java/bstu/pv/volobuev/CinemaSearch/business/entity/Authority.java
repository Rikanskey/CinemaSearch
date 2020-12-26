package bstu.pv.volobuev.CinemaSearch.business.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "authority")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Authority implements GrantedAuthority, Serializable {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
