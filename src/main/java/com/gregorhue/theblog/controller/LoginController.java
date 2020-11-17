package com.gregorhue.theblog.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.gregorhue.theblog.dto.LoginDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by gregorhue on 17.11.2020.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Named
@ViewScoped
public class LoginController implements Serializable {
	
	private static final long serialVersionUID = -7982469391438517404L;
	
	private LoginDto loginDto; 
	
	@PostConstruct
	public void onInit() {
		loginDto = new LoginDto();
	}
	
	public void login() {
		
	}

}
