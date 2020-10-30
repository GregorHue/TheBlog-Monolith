package com.gregorhue.theblog.service;

import java.util.List;

import com.gregorhue.theblog.dto.CategoryDto;

/**
 * Created by gregorhue on 06.10.2020.
 */
public interface CategoryService {
	List<CategoryDto> getAllCategories();
}
