package com.gregorhue.theblog.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.gregorhue.theblog.dto.CategoryDto;
import com.gregorhue.theblog.mapper.CategoryMapper;
import com.gregorhue.theblog.repository.CategoryRepository;
import com.gregorhue.theblog.service.CategoryService;

/**
 * Created by gregorhue on 06.10.2020.
 */
@Stateless
public class CategoryServiceImpl implements CategoryService {

	@Inject
	private CategoryRepository categoryRepository;
	@Inject
	private CategoryMapper categoryMapper;

	@Override
	public List<CategoryDto> getAll() {
		return categoryMapper.toCategoryDtos(categoryRepository.findAll());
	}
}

