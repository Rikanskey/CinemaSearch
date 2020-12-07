package bstu.pv.volobuev.CinemaSearch.web.mapper;

import bstu.pv.volobuev.CinemaSearch.business.entity.Person;
import bstu.pv.volobuev.CinemaSearch.web.dto.contentPageDTO.PersonResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper extends GenericMapper<Person, PersonResponse, PersonResponse> {
    PersonResponse toDTO(Person person);
    List<PersonResponse> toDTOs(List<Person> persons);

}
