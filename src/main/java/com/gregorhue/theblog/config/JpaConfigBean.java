package com.gregorhue.theblog.config;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by gregorhue on 04.10.2020.
 */

@Dependent
public class JpaConfigBean {
	
	@Produces
	@PersistenceContext
	EntityManager entityManager;
}
