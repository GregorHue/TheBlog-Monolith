package com.gregorhue.theblog.repository;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import com.gregorhue.theblog.model.User;

/**
 * Created by gregorhue on 04.10.2020.
 */
@RequestScoped
public class UserRepository extends AbstractRepository<User> implements Serializable {
	
	private static final long serialVersionUID = -8796315541538927333L;
	
	public UserRepository () {
		setClazz(User.class);
	}

	public User findByUsername(String username) {
		
		return entityManager.createQuery("select u from User u where u.username=:name", User.class)
				.setParameter("name", username)
				.getSingleResult();
	}
	
	public List<User> findAllByUsername(String username) {		
		return entityManager.createQuery("select u from User u where u.username=:name", User.class)
				.setParameter("name", username)
				.getResultList();
	}

}
