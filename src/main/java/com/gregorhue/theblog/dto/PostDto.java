package com.gregorhue.theblog.dto;

import java.time.LocalDateTime;

import javax.enterprise.context.Dependent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.gregorhue.theblog.model.Vote;

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
public class PostDto {
	
	private LocalDateTime createdAt;
	private LocalDateTime lastUpdatedAt;

	private String title;
	private String content;
	private Integer likes;
	private CategoryDto category;

	@JsonProperty("author_url")
	private String authorUrl;

	@JsonProperty("post_url")
	private String postUrl;

	@JsonProperty("comments_url")
	private String commentsUrl;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private Vote option;
	
	private String authorname;
}

