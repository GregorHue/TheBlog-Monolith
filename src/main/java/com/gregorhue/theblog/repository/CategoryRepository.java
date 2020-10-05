package com.gregorhue.theblog.repository;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import com.gregorhue.theblog.model.Category;

/**
 * Created by gregorhue on 04.10.2020.
 */
@SessionScoped
public class CategoryRepository extends AbstractRepository<Category> implements Serializable {
	
	private static final long serialVersionUID = -4489559789025227793L;

	public CategoryRepository() {
		setClazz(Category.class);
	}

}
