package com.gregorhue.theblog.dto;

import javax.enterprise.context.Dependent;
import javax.validation.constraints.NotEmpty;

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
@Dependent
public class LoginDto {

	@NotEmpty
	private String username;

	@NotEmpty
	private String password;

}
