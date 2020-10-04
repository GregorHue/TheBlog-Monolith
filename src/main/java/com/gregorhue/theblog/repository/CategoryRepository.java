package com.gregorhue.theblog.repository;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.gregorhue.theblog.model.Category;

/**
 * Created by gregorhue on 04.10.2020.
 */
@SessionScoped
public class CategoryRepository extends AbstractRepository<Category> implements Serializable {
	
	private static final long serialVersionUID = -4489559789025227793L;

	@Named
	@Produces
	public CategoryRepository producesCategoryRepository() {
		CategoryRepository categoryRepository = new CategoryRepository();
		categoryRepository.setClazz(Category.class);
		return categoryRepository;
	}

}
