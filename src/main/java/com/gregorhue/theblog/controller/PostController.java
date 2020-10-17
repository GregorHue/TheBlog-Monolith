package com.gregorhue.theblog.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gregorhue.theblog.dto.PostDto;
import com.gregorhue.theblog.dto.UserDto;
import com.gregorhue.theblog.service.PostService;
import com.gregorhue.theblog.service.UserService;

/**
 * Created by gregorhue on 09.10.2020.
 */

@Named
@ViewScoped
public class PostController implements Serializable {

	private static final long serialVersionUID = -968114265308184343L;

	@Inject
	private PostService postService;

	@Inject
	private UserService userService;
	
	private List<PostDto> posts;
	
	@PostConstruct
	public void onInit() {
		posts = getAllPosts();
	}
	
	public List<PostDto> getAllPosts() {	
		return postService.getAllPosts();
	}
	
	public List<PostDto> getAllPostsByAuthorId(Long authorId) {	
		return postService.getAllPostsByAuthorId(authorId);
	}

	public PostDto getPost( Long id) {
		return postService.getPostById(id);
	}


	public void createNewPost(PostDto postDto) {
		postDto.setAuthorUrl(userService.getUserByUsername("user").getUserUrl());
		if (postDto.getLikes() == null) {
			postDto.setLikes(0);
		}
		postService.saveNewPost(postDto);
	}

	public void updatePost(Long id, PostDto postDto) {
		Long userId = Long.parseLong(postDto.getAuthorUrl().split("=")[1]);
		UserDto userDto = userService.getUserById(userId);	
		postService.savePost(id, postDto);
	}

	
	public void patchPost(Long id, PostDto postDto) {
		postService.patchPost(id, postDto);		
	}

	public void deletePost(Long id) {
		postService.deletePostById(id);
	}

	public List<PostDto> getPosts() {
		return posts;
	}

}

