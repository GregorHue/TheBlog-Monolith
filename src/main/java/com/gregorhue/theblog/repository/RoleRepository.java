package com.gregorhue.theblog.repository;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.gregorhue.theblog.model.Role;

/**
 * Created by gregorhue on 04.10.2020.
 */
public class RoleRepository extends AbstractRepository<Role> {
	
	@Named
	@Produces
	public RoleRepository producesRoleRepository() {
		RoleRepository roleRepository = new RoleRepository();
		roleRepository.setClazz(Role.class);
		return roleRepository;
	}
}
