package com.gregorhue.theblog.controller;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gregorhue.theblog.dto.UserDto;
import com.gregorhue.theblog.service.UserService;



/**
 * Created by gregorhue on 09.10.2020.
 */
@Named
@ViewScoped
public class UserController implements Serializable {

	private static final long serialVersionUID = -2390884305985530004L;

	@Inject
	private UserService userService;

	private List<UserDto> users;
	
	@PostConstruct
	public void onInit() {
		users = getAllUsers();
	}

	public List<UserDto> getAllUsers() {
		return userService.getAllUsers();
	}

	public UserDto getUser(Long id) {
		return userService.getUserById(id);
	}

	public void createNewUser(UserDto userDto) {
		userService.saveNewUser(userDto);
	}
	
	public void updateUser(Long id, UserDto userDto) {	
		userService.saveUser(id, userDto);
	}

	public void deleteUser(Long id) {
		userService.deleteUserById(id);
	}

	public List<UserDto> getUsers() {
		return users;
	}
	
}

