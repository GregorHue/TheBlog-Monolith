package com.gregorhue.theblog.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gregorhue.theblog.dto.CommentDto;
import com.gregorhue.theblog.model.Comment;

/**
 * Created by gregorhue on 06.10.2020.
 */
@Mapper(componentModel = "cdi")
public interface CommentMapper {

	@Mapping(target = "commentUrl", expression = "java(\"/comment?id=\" + comment.getId())")
	@Mapping(target = "postUrl", expression = "java(\"/post?id=\" + comment.getPost().getId())")
	@Mapping(target = "authorUrl", expression = "java(\"/user?id=\" + comment.getAuthor().getId())")
	CommentDto toCommentDto(Comment comment);

	Comment toComment(CommentDto commentDto);

	List<CommentDto> toCommentDtos(List<Comment> posts);
}
