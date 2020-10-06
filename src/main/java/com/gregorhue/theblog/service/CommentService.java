package com.gregorhue.theblog.service;

import java.util.List;

import com.gregorhue.theblog.dto.CommentDto;

/**
 * Created by gregorhue on 06.10.2020.
 */
public interface CommentService {

	List<CommentDto> getAllCommentsByPostId(Long id);

	CommentDto getCommentById(Long id);

	CommentDto saveNewComment(CommentDto commentDto);

	CommentDto saveComment(Long id, CommentDto commentDto);

	CommentDto patchComment(Long id, CommentDto commentDto);

	void deleteCommentById(Long id);
}
