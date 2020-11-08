package com.gregorhue.theblog.repository;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import com.gregorhue.theblog.model.Category;

/**
 * Created by gregorhue on 04.10.2020.
 */
@RequestScoped
public class CategoryRepository extends AbstractRepository<Category> implements Serializable {
	
	private static final long serialVersionUID = -4489559789025227793L;

	public CategoryRepository() {
		setClazz(Category.class);
	}

	public Category findByName(String name) {
		return entityManager.createQuery("select c from Category c where c.name=:name", Category.class)
				.setParameter("name", name)
				.getSingleResult();
	}

}
