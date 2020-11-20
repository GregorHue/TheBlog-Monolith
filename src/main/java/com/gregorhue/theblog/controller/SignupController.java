package com.gregorhue.theblog.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.gregorhue.theblog.dto.SignupDto;
import com.gregorhue.theblog.service.SignupService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by gregorhue on 19.11.2020.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Named
@RequestScoped
public class SignupController implements Serializable {

	private static final long serialVersionUID = -8884194174519754622L;
	private SignupDto signupDto;
	
	@Inject
	private SignupService signupService;
	
	@PostConstruct
	public void onInit() {
		signupDto = SignupDto.builder().build();
	}
	
	public void signup() {
		signupService.signup(signupDto);
	}
}
