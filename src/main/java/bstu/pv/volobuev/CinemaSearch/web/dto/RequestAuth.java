package bstu.pv.volobuev.CinemaSearch.web.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestAuth {
    String grant_type;
    String username;
    String password;
}
