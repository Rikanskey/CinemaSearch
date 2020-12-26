package bstu.pv.volobuev.CinemaSearch.business.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity(name = "usr")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserAccount implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String username;

    @NotNull
    String password;

    String avatar;

    boolean accountNonExpired;

    boolean accountNonLocked;

    boolean credentialsNonExpired;

    boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usr_authorities",
            joinColumns = @JoinColumn(name = "usr_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    Set<Authority> authorities;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    Set<UserRatingMovie> movie;

    @Override
    public Collection<Authority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void rateMovie(Movie newMovie, Long rating){
        UserRatingMovie userRate = new UserRatingMovie();
        movie.add(userRate);
        newMovie.getUsersRating().add(userRate);
        userRate.setUser(this);
        userRate.setMovie(newMovie);
        userRate.setRating(rating);
    }
}
