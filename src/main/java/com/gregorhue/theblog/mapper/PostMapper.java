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

	@Mapping(target = "postUrl", expression = "java(\"/posts/\" + post.getId())")
	@Mapping(target = "authorUrl", expression = "java(\"/users/\" + post.getAuthor().getId())")
	@Mapping(target = "commentsUrl", expression = "java(\"/posts/\" + post.getId() + \"/comments\")")
	PostDto toPostDto(Post post);

	Post toPost(PostDto postDto);

	List<PostDto> toPostDtos(List<Post> posts);
}
