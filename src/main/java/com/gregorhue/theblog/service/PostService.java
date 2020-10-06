package com.gregorhue.theblog.service;

import java.util.List;

import com.gregorhue.theblog.dto.PostDto;

/**
 * Created by gregorhue on 06.10.2020.
 */
public interface PostService {

	List<PostDto> getAllPosts();

	List<PostDto> getAllPostsByAuthorId(Long id);

	PostDto getPostById(Long id);

	PostDto saveNewPost(PostDto postDto);

	PostDto savePost(Long id, PostDto postDto);

	PostDto patchPost(Long id, PostDto postDto);

	void deletePostById(Long id);
}

