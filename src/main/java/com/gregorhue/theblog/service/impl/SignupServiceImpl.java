package com.gregorhue.theblog.service.impl;

import com.gregorhue.theblog.controller.LoginController;
import com.gregorhue.theblog.controller.SignupController;
import com.gregorhue.theblog.dto.LoginDto;
import com.gregorhue.theblog.dto.SignupDto;
import com.gregorhue.theblog.model.Role;
import com.gregorhue.theblog.model.User;
import com.gregorhue.theblog.repository.RoleRepository;
import com.gregorhue.theblog.repository.UserRepository;
import com.gregorhue.theblog.service.SignupService;
import com.gregorhue.theblog.service.UserService;

import java.time.LocalDateTime;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.transaction.Transactional;

/**
 * Created by gregorhue on 20.11.2020.
 */

@Stateless
public class SignupServiceImpl implements SignupService {
	
	@Inject
	private UserService userService; 
	
	@Inject
	private UserRepository userRepository;
	
	@Inject
	private RoleRepository roleRepository;
	
	@Inject
	private Pbkdf2PasswordHash passwordHash;
	
	@Inject
	FacesContext facesContext;

	@Override
	public boolean signup(SignupDto signupDto) {
		boolean result = false;
		if (signupDto.getPassword().equals(signupDto.getConfirmPassword())) {
			if (!userService.isUsernameExist(signupDto.getUsername())) {
				User user = User.builder().username(signupDto.getUsername()).build();
				user.setCreatedAt(LocalDateTime.now());
				user.setPassword(passwordHash.generate(signupDto.getPassword().toCharArray()));
				Role role = roleRepository.findByName("ROLE_USER");
				user.getRoles().add(role);
				role.getUsers().add(user);
				userRepository.saveNewEntity(user);
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Account successfully created", null));
				result = true;
			} else {
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username already exits", null));
			}
		} else {
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No consistent inputs for password", null));
		}
		return result;
	}

}
