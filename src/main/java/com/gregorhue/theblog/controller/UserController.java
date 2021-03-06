package com.gregorhue.theblog.controller;

import com.gregorhue.theblog.dto.UserDto;
import com.gregorhue.theblog.service.UserService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.PostConstruct;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gregorhue on 09.10.2020.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Named
@ViewScoped
public class UserController implements Serializable {

	private static final long serialVersionUID = -4309206576313570614L;

	@Inject
	private UserService userService;

	private List<UserDto> users;
	private UserDto currentUser;

	@PostConstruct
	public void onInit() {
		users = userService.getAllUsers().stream().filter(user -> user.getDeletedTs() == null).collect(Collectors.toList());
	}

	private boolean validate(String string) {
		return string != null && !string.equals("");
	}

	public String getCompleteAddress(UserDto user) {
		String address = "";
		if (this.validate(user.getHouseNumber().toString())) {
			address += user.getHouseNumber();
		}
		if (this.validate(user.getStreet())) {
			if (this.validate(address)) {
				address += ", ";
			}
			address += user.getStreet();
		}
		if (this.validate(user.getCity())) {
			if (this.validate(address)) {
				address += ", ";
			}
			address += user.getCity();
		}
		if (this.validate(user.getPostalCode())) {
			if (this.validate(address)) {
				address += ", ";
			}
			address += user.getPostalCode();
		}
		return address;
	}

	public void deleteUser() {
		userService.deleteUserById(currentUser.getId());
		users.remove(currentUser);
		currentUser = null;
	}

}
