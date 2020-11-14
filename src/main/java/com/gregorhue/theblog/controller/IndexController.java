package com.gregorhue.theblog.controller;

import com.gregorhue.theblog.dto.CategoryDto;
import com.gregorhue.theblog.dto.PostDto;
import com.gregorhue.theblog.model.Vote;
import com.gregorhue.theblog.service.CategoryService;
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
	
	@Inject
	private CategoryService categoryService;
	
	private List<PostDto> posts;

	private PostDto currentPost;
	
	private List<CategoryDto> categories;

	private String sortOrder = "newest";

	private String filterOrder = "All";
	
	@PostConstruct
	public void onInit() {
		posts = postService.getAllPosts();
		categories = categoryService.getAllCategories();
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

	public void updatePost() {
		Long postId = Long.parseLong(currentPost.getPostUrl().split("=")[1]);
		PostDto updatedPostDto = postService.updatePost(postId, currentPost);
		posts = posts.stream().filter(p -> !p.getPostUrl().equals(currentPost.getPostUrl())).collect(Collectors.toList());
		posts.add(updatedPostDto);
	}

	
	private void patchPost(Long id, PostDto postDto) {
		postService.patchPost(id, postDto);		
	}
	
	public void upvotePost(PostDto postDto) {
		Long postId = Long.parseLong(postDto.getPostUrl().split("=")[1]);
		postDto.setOption(Vote.UPVOTE);
		patchPost(postId, postDto);
		posts = postService.getAllPosts();
	}

	public void downvotePost(PostDto postDto) {
		Long postId = Long.parseLong(postDto.getPostUrl().split("=")[1]);
		postDto.setOption(Vote.DOWNVOTE);
		patchPost(postId, postDto);
		posts = postService.getAllPosts();
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

	public List<CategoryDto> getCategories() {
		return categories;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getFilterOrder() {
		return filterOrder;
	}

	public void setFilterOrder(String filterOrder) {
		this.filterOrder = filterOrder;
	}

	public void sort() {
		System.out.println(sortOrder);
	}

	public void filter() {
		System.out.println(filterOrder);
	}

}

