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

	void saveNewPost(PostDto postDto);

	PostDto updatePost(Long id, PostDto postDto);

    void patchPost(Long id, PostDto postDto);

	void deletePostById(Long id);
}

