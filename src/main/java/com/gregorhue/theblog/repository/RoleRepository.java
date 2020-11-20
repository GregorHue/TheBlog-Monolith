package com.gregorhue.theblog.repository;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import com.gregorhue.theblog.model.Role;

/**
 * Created by gregorhue on 04.10.2020.
 */
@RequestScoped
public class RoleRepository extends AbstractRepository<Role> implements Serializable {
	
	private static final long serialVersionUID = -5227386044581687410L;

	public RoleRepository() {
		setClazz(Role.class);
	}

	public Role findByName(String name) {
		
		return entityManager.createQuery("select r from Role r where r.name=:name", Role.class)
				.setParameter("name", name)
				.getSingleResult();
	}
}
