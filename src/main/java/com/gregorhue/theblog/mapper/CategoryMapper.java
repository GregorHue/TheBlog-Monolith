package com.gregorhue.theblog.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.gregorhue.theblog.dto.CategoryDto;
import com.gregorhue.theblog.model.Category;

/**
 * Created by gregorhue on 06.10.2020.
 */
@Mapper(componentModel = "cdi")
public interface CategoryMapper {

	CategoryDto toCategoryDto(Category category);

	Category toCategory(CategoryDto categoryDto);

	List<CategoryDto> toCategoryDtos(List<Category> categories);
}

