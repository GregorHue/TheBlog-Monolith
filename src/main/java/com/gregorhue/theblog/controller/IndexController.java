package com.gregorhue.theblog.controller;

import com.gregorhue.theblog.dto.PostDto;
import com.gregorhue.theblog.dto.UserDto;
import com.gregorhue.theblog.model.Vote;
import com.gregorhue.theblog.service.PostService;
import com.gregorhue.theblog.service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gregorhue on 09.10.2020.
 */

@Named
@ViewScoped
public class IndexController implements Serializable {

	private static final long serialVersionUID = -968114265308184343L;

	@Inject
	private PostService postService;

	@Inject
	private UserService userService;
	
	private List<PostDto> posts;

	private PostDto currentPost;
	
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

	
	private void patchPost(Long id, PostDto postDto) {
		postService.patchPost(id, postDto);		
	}
	
	public void upvotePost(PostDto postDto) {
		Long postId = Long.parseLong(postDto.getPostUrl().split("=")[1]);
		postDto.setOption(Vote.UPVOTE);
		patchPost(postId, postDto);
		posts = getAllPosts();
	}

	public void downvotePost(PostDto postDto) {
		Long postId = Long.parseLong(postDto.getPostUrl().split("=")[1]);
		postDto.setOption(Vote.DOWNVOTE);
		patchPost(postId, postDto);
		posts = getAllPosts();
	}

	public void deletePost() {
		Long postId = Long.parseLong(currentPost.getPostUrl().split("=")[1]);
		postService.deletePostById(postId);
		posts = posts.stream().filter(post -> !post.getPostUrl().equals(currentPost.getPostUrl())).collect(Collectors.toList());
	}

	public List<PostDto> getPosts() {
		return posts;
	}

	public PostDto getCurrentPost() {
		return currentPost;
	}

	public void setCurrentPost(PostDto currentPost) {
		this.currentPost = currentPost;
	}
}

