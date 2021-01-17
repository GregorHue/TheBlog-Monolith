package com.gregorhue.theblog.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gregorhue.theblog.dto.PostDto;
import com.gregorhue.theblog.model.Post;

/**
 * Created by gregorhue on 06.10.2020.
 */
@Mapper(componentModel = "cdi")
public interface PostMapper {

	@Mapping(target = "postUrl", expression = "java(\"/post?id=\" + post.getId())")
	@Mapping(target = "authorUrl", expression = "java(\"/user?id=\" + post.getAuthor().getId())")
	@Mapping(target = "createdAt", expression = 
			"java(post.getCreatedAt() != null ? java.sql.Timestamp.valueOf(post.getCreatedAt()) : null)")
	@Mapping(target = "lastUpdatedAt", expression = 
			"java(post.getLastUpdatedAt() != null ? java.sql.Timestamp.valueOf(post.getLastUpdatedAt()) : null)")
	PostDto toPostDto(Post post);

	@Mapping(target = "createdAt", expression = 
			"java(postDto.getCreatedAt() != null ? new java.sql.Timestamp(postDto.getCreatedAt().getTime()).toLocalDateTime() : null)")
	@Mapping(target = "lastUpdatedAt", expression = 
			"java(postDto.getLastUpdatedAt() != null ? new java.sql.Timestamp(postDto.getLastUpdatedAt().getTime()).toLocalDateTime() : null)")
	Post toPost(PostDto postDto);

	List<PostDto> toPostDtos(List<Post> posts);
}
