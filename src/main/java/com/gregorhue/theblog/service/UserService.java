package com.gregorhue.theblog.service;

import java.util.List;

import com.gregorhue.theblog.dto.UserDto;

/**
 * Created by gregorhue on 06.10.2020.
 */
public interface UserService {

	List<UserDto> getAllUsers();

	UserDto getUserById(Long id);

	UserDto getUserByUsername(String username);

    void saveNewUser(UserDto userDto);

	void updateUser(Long id, UserDto UserDto);

	void deleteUserById(Long id);
	
	boolean isUsernameExist(String username);
}

