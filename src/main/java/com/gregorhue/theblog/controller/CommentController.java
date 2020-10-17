package com.gregorhue.theblog.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gregorhue.theblog.dto.CommentDto;
import com.gregorhue.theblog.dto.PostDto;
import com.gregorhue.theblog.service.CommentService;
import com.gregorhue.theblog.service.PostService;
import com.gregorhue.theblog.service.UserService;

/**
 * Created by gregorhue on 09.10.2020.
 */

@Named
@ViewScoped
public class CommentController implements Serializable {

	private static final long serialVersionUID = -6660829277671473823L;

	@Inject
	private CommentService commentService;

	@Inject
	private UserService userService;
	
	@Inject
	private PostService postService;
	

	private List<CommentDto> comments;
	
	private PostDto post;
	
	@PostConstruct
	public void onInit() {
		post = postService.getPostById(1L);
		comments = commentService.getAllCommentsByPostId(1L);	;	
	}

	public List<CommentDto> getAllCommentsByPostId(Long postId) {	
		return commentService.getAllCommentsByPostId(postId);	
	}

	public CommentDto getComment(Long id) {
		return commentService.getCommentById(id);
	}

	public void createNewComment(CommentDto commentDto) {
		commentDto.setAuthorUrl(userService.getUserByUsername("user").getUserUrl());
		if (commentDto.getLikes() == null) {
			commentDto.setLikes(0);
		}
		commentService.saveNewComment(commentDto);
	}

	public void updateComment(Long id, CommentDto commentDto) {
		Long userId = Long.parseLong(commentDto.getAuthorUrl().split("=")[1]);	
		commentService.saveComment(id, commentDto);
	}

	public void patchComment(Long id, CommentDto commentDto) {
		commentService.patchComment(id, commentDto);
	}

	public void deleteComment(Long id) {
		commentService.deleteCommentById(id);
	}

	public List<CommentDto> getComments() {
		return comments;
	}

	public PostDto getPost() {
		return post;
	}

}

