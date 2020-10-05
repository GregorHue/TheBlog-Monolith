package com.gregorhue.theblog.dto;

import java.time.LocalDateTime;

import javax.inject.Named;

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
@Named
public class CommentDto {
	
	private LocalDateTime createdAt;	
	private LocalDateTime lastUpdatedAt;

	private String content;
	private Integer likes;

	@JsonProperty("comment_url")
	private String commentUrl;

	@JsonProperty("author_url")
	private String authorUrl;

	@JsonProperty("post_url")
	private String postUrl;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private Vote option;
	
	private String authorname;
}

