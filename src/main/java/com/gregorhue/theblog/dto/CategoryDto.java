package com.gregorhue.theblog.dto;

import javax.enterprise.context.Dependent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by gregorhue on 05.10.2020.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Dependent
public class CategoryDto {

	private String name;
}
