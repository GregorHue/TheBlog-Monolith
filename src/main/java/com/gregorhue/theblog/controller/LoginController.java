package com.gregorhue.theblog.controller;

import com.gregorhue.theblog.dto.LoginDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

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

	@Inject
	FacesContext facesContext;

	@Inject
	SecurityContext securityContext;

	@PostConstruct
	public void onInit() {
		loginDto = LoginDto.builder().build();
	}
	
	public void login() throws IOException {
		switch (processAuthentication()) {
			case SEND_CONTINUE:
				facesContext.renderResponse();
				break;
			case SEND_FAILURE:
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Credentials", null));
				break;
			case SUCCESS:
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Login was successful", null));
				break;
		default:
			break;
		}
		loginDto = LoginDto.builder().build();
	}
	
	public String logout() throws ServletException {
		((HttpServletRequest) getExternalContext().getRequest()).logout();
		return "/index.xhtml?faces-redirect=true";
	}

	private AuthenticationStatus processAuthentication() {
		ExternalContext externalContext = getExternalContext();
		return securityContext.authenticate((HttpServletRequest) externalContext.getRequest(), (HttpServletResponse) externalContext.getResponse(),
				AuthenticationParameters.withParams().credential(new UsernamePasswordCredential(loginDto.getUsername(), loginDto.getPassword())));
	}

	private ExternalContext getExternalContext() {
		return facesContext.getExternalContext();
	}

}
