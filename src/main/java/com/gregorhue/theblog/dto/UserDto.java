package com.gregorhue.theblog.dto;

import java.time.LocalDateTime;

import javax.enterprise.context.Dependent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.gregorhue.theblog.model.Gender;

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
public class UserDto {
	
	private LocalDateTime createdAt;	
	private LocalDateTime lastUpdatedAt;

	private String username;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private Gender gender;
	
	private String city;

	private String street;

	private Integer houseNumber;

	private String postalCode;

	@JsonProperty("user_url")
	private String userUrl;

	@JsonProperty("posts_url")
	private String postsUrl;
	
	private LocalDateTime deletedTs;

}
