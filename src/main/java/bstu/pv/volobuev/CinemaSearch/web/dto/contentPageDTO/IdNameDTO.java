package bstu.pv.volobuev.CinemaSearch.web.dto.contentPageDTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IdNameDTO {
    Long id;
    String name;
}