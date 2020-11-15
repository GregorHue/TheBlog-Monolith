package com.gregorhue.theblog.controller;

import com.gregorhue.theblog.dto.CategoryDto;
import com.gregorhue.theblog.dto.PostDto;
import com.gregorhue.theblog.helper.SortAndFilterHelper;
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
	private List<CategoryDto> cbCategories;

	private String sortOrder = "newest";

	private String filter = "All";
	
	@PostConstruct
	public void onInit() {
		posts = postService.getAllPosts();
		posts = SortAndFilterHelper.sort(posts, sortOrder);
		categories = categoryService.getAllCategories();
		cbCategories = categories.stream().filter(c -> !c.getName().equals("All")).collect(Collectors.toList());
	}
	
	public List<PostDto> getAllPostsByAuthorId(Long authorId) {	
		return postService.getAllPostsByAuthorId(authorId);
	}

	public PostDto getPost( Long id) {
		return postService.getPostById(id);
	}
	
	public void createNewPost() {
		currentPost = new PostDto();
		currentPost.setCategory(CategoryDto.builder().build());
	}

	public void saveNewPost() {
		currentPost.setAuthorUrl(userService.getUserByUsername("user").getUserUrl());
		if (currentPost.getLikes() == null) {
			currentPost.setLikes(0);
		}
		postService.saveNewPost(currentPost);
		posts = postService.getAllPosts();
		posts = SortAndFilterHelper.sort(posts, sortOrder);
	}

	public void updatePost() {
		Long postId = Long.parseLong(currentPost.getPostUrl().split("=")[1]);
		PostDto updatedPostDto = postService.updatePost(postId, currentPost);
		posts = posts.stream().filter(p -> !p.getPostUrl().equals(currentPost.getPostUrl())).collect(Collectors.toList());
		posts.add(updatedPostDto);
		posts = SortAndFilterHelper.sort(posts, sortOrder);
	}

	
	private void patchPost(Long id, PostDto postDto) {
		postService.patchPost(id, postDto);		
	}
	
	public void upvotePost(PostDto postDto) {
		Long postId = Long.parseLong(postDto.getPostUrl().split("=")[1]);
		postDto.setOption(Vote.UPVOTE);
		patchPost(postId, postDto);
		posts = postService.getAllPosts();
		posts = SortAndFilterHelper.sort(posts, sortOrder);
	}

	public void downvotePost(PostDto postDto) {
		Long postId = Long.parseLong(postDto.getPostUrl().split("=")[1]);
		postDto.setOption(Vote.DOWNVOTE);
		patchPost(postId, postDto);
		posts = postService.getAllPosts();
		posts = SortAndFilterHelper.sort(posts, sortOrder);
	}

	public void deletePost() {
		Long postId = Long.parseLong(currentPost.getPostUrl().split("=")[1]);
		postService.deletePostById(postId);
		posts = posts.stream().filter(post -> !post.getPostUrl().equals(currentPost.getPostUrl())).collect(Collectors.toList());
		posts = SortAndFilterHelper.sort(posts, sortOrder);
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
		return filter;
	}

	public void setFilterOrder(String filterOrder) {
		this.filter = filterOrder;
	}

	public List<CategoryDto> getCbCategories() {
		return cbCategories;
	}

	public void setCbCategories(List<CategoryDto> cbCategories) {
		this.cbCategories = cbCategories;
	}

	public void sort() {
		posts = SortAndFilterHelper.sort(posts, sortOrder);
	}

	public void filter() {
		System.out.println(filter);
	}

}

