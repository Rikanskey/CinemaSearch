package bstu.pv.volobuev.CinemaSearch.web.mapper;

import bstu.pv.volobuev.CinemaSearch.business.entity.UserAccount;
import bstu.pv.volobuev.CinemaSearch.web.dto.UserRegistrationRequest;
import bstu.pv.volobuev.CinemaSearch.web.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<UserAccount, UserResponse, UserRegistrationRequest> {
    UserResponse toDTO(UserAccount userAccount);
}
