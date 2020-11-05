package com.gregorhue.theblog.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gregorhue.theblog.dto.UserDto;
import com.gregorhue.theblog.service.UserService;

/**
 * Created by gregorhue on 04.11.2020.
 */
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

	public UserDto getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(UserDto currentUser) {
		this.currentUser = currentUser;
	}

	public int getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(int currentUserId) {
		this.currentUserId = currentUserId;
	}
	
}
