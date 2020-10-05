package com.gregorhue.theblog.repository;

import java.io.Serializable;

import com.gregorhue.theblog.model.Role;

/**
 * Created by gregorhue on 04.10.2020.
 */
public class RoleRepository extends AbstractRepository<Role> implements Serializable {
	
	private static final long serialVersionUID = -5227386044581687410L;

	public RoleRepository() {
		setClazz(Role.class);
	}
}
