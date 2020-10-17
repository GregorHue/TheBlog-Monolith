package com.gregorhue.theblog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gregorhue.theblog.dto.SignupDto;
import com.gregorhue.theblog.model.User;

/**
 * Created by gregorhue on 06.10.2020.
 */
@Mapper(componentModel = "cdi")
public interface SignupMapper {

	@Mapping(target = "userUrl", expression = "java(\"/users?id=\" + user.getId())")
	@Mapping(target = "password", ignore = true)
	@Mapping(target = "confirmPassword", ignore = true)
	SignupDto toSignupDto(User user);

	@Mapping(target = "password", ignore = true)
	User toUser(SignupDto dto);
}
