package com.gregorhue.theblog.service;

import com.gregorhue.theblog.dto.SignupDto;

/**
 * Created by gregorhue on 06.10.2020.
 */
public interface SignupService {

	SignupDto saveNewUser(SignupDto signupDto);

}
