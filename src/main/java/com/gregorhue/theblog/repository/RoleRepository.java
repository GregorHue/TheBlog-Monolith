package com.gregorhue.theblog.repository;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.gregorhue.theblog.model.Role;

/**
 * Created by gregorhue on 04.10.2020.
 */
public class RoleRepository extends AbstractRepository<Role> implements Serializable {
	
	private static final long serialVersionUID = -5227386044581687410L;

	@Named
	@Produces
	public RoleRepository producesRoleRepository() {
		RoleRepository roleRepository = new RoleRepository();
		roleRepository.setClazz(Role.class);
		return roleRepository;
	}
}
