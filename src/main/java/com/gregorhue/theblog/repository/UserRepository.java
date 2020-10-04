package com.gregorhue.theblog.repository;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.gregorhue.theblog.model.User;

/**
 * Created by gregorhue on 04.10.2020.
 */
public class UserRepository extends AbstractRepository<User> implements Serializable {
	
	private static final long serialVersionUID = -8796315541538927333L;

	@Named
	@Produces
	public UserRepository producesUserRepository() {
		UserRepository userRepository = new UserRepository();
		userRepository.setClazz(User.class);
		return userRepository;
	}

}
