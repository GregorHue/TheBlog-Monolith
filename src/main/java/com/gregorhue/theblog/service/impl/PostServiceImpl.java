package com.gregorhue.theblog.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

import com.gregorhue.theblog.dto.PostDto;
import com.gregorhue.theblog.mapper.PostMapper;
import com.gregorhue.theblog.model.Category;
import com.gregorhue.theblog.model.Post;
import com.gregorhue.theblog.model.User;
import com.gregorhue.theblog.model.Vote;
import com.gregorhue.theblog.repository.CategoryRepository;
import com.gregorhue.theblog.repository.PostRepository;
import com.gregorhue.theblog.repository.UserRepository;
import com.gregorhue.theblog.service.PostService;

/**
 * Created by gregorhue on 08.10.2020.
 */
@Stateless
public class PostServiceImpl implements PostService {

	@Inject
	private UserRepository userRepository;
	@Inject
	private CategoryRepository categoryRepository;
	@Inject
	private PostRepository postRepository;
	@Inject
	private PostMapper postMapper;
	@Inject
	SecurityContext securityContext;

	@Override
	public List<PostDto> getAllPosts() {
		List<Post> posts = postRepository.findAll();
		posts.forEach(post -> post.setAuthorname(post.getAuthor().getUsername()));
		return postMapper.toPostDtos(posts);	
	}

	@Override
	public List<PostDto> getAllPostsByAuthorId(Long id) {
		List<Post> posts = postRepository.findAllByAuthorId(id);
		posts.forEach(post -> post.setAuthorname(post.getAuthor().getUsername()));
		return postMapper.toPostDtos(posts);

	}

	@Override
	public PostDto getPostById(Long id) {
		Post post = postRepository.findOne(id);
		if (post != null) {
			post.setAuthorname(post.getAuthor().getUsername());
		}
		return postMapper.toPostDto(post);
	}

	@Override
	public void saveNewPost(PostDto postDto) {
		Post post = postMapper.toPost(postDto);
		post.setCreatedAt(LocalDateTime.now());
		processPostDto(postDto, post);
		postRepository.saveNewEntity(post);
	}

	@Override
	public PostDto updatePost(Long id, PostDto postDto) {
		Post post = postMapper.toPost(postDto);
		post.setLastUpdatedAt(LocalDateTime.now());
		post.setId(id);
		processPostDto(postDto, post);
		return postMapper.toPostDto(postRepository.updateEntry(post));
		
	}

	private void processPostDto(PostDto postDto, Post post) {
		String username = securityContext.getCallerPrincipal().getName();
		User author = userRepository.findByUsername(username);
		post.setAuthor(author);
		Category category = categoryRepository.findByName(postDto.getCategory().getName());
		post.setCategory(category);
		post.setAuthorname(post.getAuthor().getUsername());
	}

	@Override
	public void patchPost(Long id, PostDto postDto) {
		Post post = postRepository.findOne(id);
		if (post != null && postDto.getOption() != null) {
			if (postDto.getOption() == Vote.UPVOTE) {
				post.setLikes(post.getLikes() + 1);
			} else {
				post.setLikes(post.getLikes() - 1);
			}
			postRepository.updateEntry(post);
		}

	}

	@Override
	public void deletePostById(Long id) {
		postRepository.deleteById(id);
	}

}
