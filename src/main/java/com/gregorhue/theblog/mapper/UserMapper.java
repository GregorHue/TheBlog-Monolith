package com.gregorhue.theblog.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gregorhue.theblog.dto.UserDto;
import com.gregorhue.theblog.model.User;

/**
 * Created by gregorhue on 06.10.2020.
 */
@Mapper(componentModel = "cdi")
public interface UserMapper {

	@Mapping(target = "userUrl", expression = "java(\"/users?id=\" + user.getId())")
	@Mapping(target = "password", ignore = true)
	UserDto toUserDto(User user);

	@Mapping(target = "password", ignore = true)
	User toUser(UserDto userDto);

	List<UserDto> toUserDtos(List<User> users);
}
