package bstu.pv.volobuev.CinemaSearch.web.mapper;

import bstu.pv.volobuev.CinemaSearch.business.entity.Country;
import bstu.pv.volobuev.CinemaSearch.web.dto.contentPageDTO.CountryResponse;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CountryMapper extends GenericMapper<Country, CountryResponse, CountryResponse> {
    CountryResponse toDTO(Country country);
    List<CountryResponse> toDTOs(Set<Country> countries);
}
