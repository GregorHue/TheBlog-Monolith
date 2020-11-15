package com.gregorhue.theblog.controller;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gregorhue.theblog.dto.UserDto;
import com.gregorhue.theblog.service.UserService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by gregorhue on 04.11.2020.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Named
@ViewScoped
public class ProfileController implements Serializable {

	private static final long serialVersionUID = 4542998241010925275L;

	@Inject
	private UserService userService;

	private int currentUserId;
	private UserDto currentUser;
	
	public void onInit() {
		currentUser = userService.getUserById((long) currentUserId);
	}

}
