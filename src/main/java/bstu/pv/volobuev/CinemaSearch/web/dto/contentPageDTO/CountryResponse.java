package bstu.pv.volobuev.CinemaSearch.web.dto.contentPageDTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CountryResponse{
    Long id;
    String name;
}
