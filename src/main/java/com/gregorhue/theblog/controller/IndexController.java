package com.gregorhue.theblog.controller;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gregorhue.theblog.dto.CategoryDto;
import com.gregorhue.theblog.dto.PostDto;
import com.gregorhue.theblog.helper.SortAndFilterHelper;
import com.gregorhue.theblog.model.Vote;
import com.gregorhue.theblog.service.CategoryService;
import com.gregorhue.theblog.service.PostService;
import com.gregorhue.theblog.service.UserService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by gregorhue on 09.10.2020.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	
	@Inject
	FacesContext facesContext;
	
	@Inject
	UploadController uploadController;
	
	@Inject
	ImageController imageController;
	
	private List<PostDto> posts;
	private List<PostDto> filteredAndSortedPosts;

	private PostDto currentPost;
	
	private List<CategoryDto> categories;
	private List<CategoryDto> cbCategories;

	private String sortOrder = "newest";

	private String filter = "All";
	
	
	@PostConstruct
	public void onInit() {
		posts = postService.getAllPosts();
		filteredAndSortedPosts = SortAndFilterHelper.sortAndFilter(posts, sortOrder, filter);
		categories = categoryService.getAllCategories();
		cbCategories = categories.stream().filter(c -> !c.getName().equals("All")).collect(Collectors.toList());
	}

	public PostDto getPost( Long id) {
		return postService.getPostById(id);
	}
	
	public void createNewPost() {
		currentPost = new PostDto();
		currentPost.setCategory(CategoryDto.builder().build());	
		uploadController.setResizedImage(null);
	}

	public void saveNewPost() {
		currentPost.setAuthorUrl(userService.getUserByUsername("user").getUserUrl());
		if (currentPost.getLikes() == null) {
			currentPost.setLikes(0);
		}
		currentPost.setImage(uploadController.getResizedImage());
		postService.saveNewPost(currentPost);		
		posts = postService.getAllPosts();
		filteredAndSortedPosts = SortAndFilterHelper.sortAndFilter(posts, sortOrder, filter);
	}

	public void updatePost() {
		Long postId = Long.parseLong(currentPost.getPostUrl().split("=")[1]);
		if (uploadController.getResizedImage() != null) {
			currentPost.setImage(uploadController.getResizedImage());
		}
		postService.updatePost(postId, currentPost);
		posts = postService.getAllPosts();
		filteredAndSortedPosts = SortAndFilterHelper.sortAndFilter(posts, sortOrder, filter);
	}
	
	private void patchPost(Long id, PostDto postDto) {
		postService.patchPost(id, postDto);		
	}
	
	public void upvotePost(PostDto postDto) {
		Long postId = Long.parseLong(postDto.getPostUrl().split("=")[1]);
		postDto.setOption(Vote.UPVOTE);
		patchPost(postId, postDto);
		posts = postService.getAllPosts();
		filteredAndSortedPosts = SortAndFilterHelper.sortAndFilter(posts, sortOrder, filter);
	}

	public void downvotePost(PostDto postDto) {
		Long postId = Long.parseLong(postDto.getPostUrl().split("=")[1]);
		postDto.setOption(Vote.DOWNVOTE);
		patchPost(postId, postDto);
		posts = postService.getAllPosts();
		filteredAndSortedPosts = SortAndFilterHelper.sortAndFilter(posts, sortOrder, filter);
	}

	public void deletePost() {
		Long postId = Long.parseLong(currentPost.getPostUrl().split("=")[1]);
		postService.deletePostById(postId);
		posts = postService.getAllPosts();
		filteredAndSortedPosts = SortAndFilterHelper.sortAndFilter(posts, sortOrder, filter);
	}

	public void sort() {
		filteredAndSortedPosts = SortAndFilterHelper.sortAndFilter(posts, sortOrder, filter);
	}

	public void filter() {
		filteredAndSortedPosts = SortAndFilterHelper.sortAndFilter(posts, sortOrder, filter);
	}
	
	public void toggleGrowl() {
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Signup or login to leave a vote!", null));
	}
	
	public void initUpdate(PostDto post) {
		currentPost = post;
		imageController.setCurrentPost(post);
		uploadController.setResizedImage(null);
	}
}

