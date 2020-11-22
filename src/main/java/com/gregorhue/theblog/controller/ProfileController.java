package com.gregorhue.theblog.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;

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

	@Inject
	SecurityContext securityContext;
	
	@Inject
	FacesContext facesContext;

	private String currentUserName;
	private UserDto currentUser;

	@PostConstruct
	public void onInit() {
		currentUserName = securityContext.getCallerPrincipal().getName();
		currentUser = userService.getUserByUsername(currentUserName);
	}
	
	public void updateUser() {
		userService.updateUser(currentUser.getId(), currentUser);
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Changes successfully saved", null));
	}

}
