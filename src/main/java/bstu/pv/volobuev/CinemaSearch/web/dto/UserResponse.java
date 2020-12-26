package bstu.pv.volobuev.CinemaSearch.web.dto;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String username;
    List<UserMoviesRatingResponse> movie;
}
