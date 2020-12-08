package bstu.pv.volobuev.CinemaSearch.web.dto.contentPageDTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonResponse{
    Long id;
    String name;
}
