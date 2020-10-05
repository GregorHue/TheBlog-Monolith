package com.gregorhue.theblog.dto;

import javax.inject.Named;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by gregorhue on 05.10.2020.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Named
public class SignupDto {

	@NotNull
	@NotEmpty(message = "Username must not be empty!")
	private String username;

	@NotNull
	@NotEmpty(message = "Password must not be empty!")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String confirmPassword;

	@JsonProperty(access = Access.READ_ONLY, value = "user_url")
	private String userUrl;
}

