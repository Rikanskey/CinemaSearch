package bstu.pv.volobuev.CinemaSearch.web.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestRating {
    Long rating;
}
