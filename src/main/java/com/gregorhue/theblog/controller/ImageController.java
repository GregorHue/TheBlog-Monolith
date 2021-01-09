package com.gregorhue.theblog.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.inject.Inject;
import javax.servlet.http.Part;

import org.omnifaces.cdi.GraphicImageBean;
import com.gregorhue.theblog.dto.PostDto;
import com.gregorhue.theblog.service.PostService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by gregorhue on 31.12.2020.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@GraphicImageBean
public class ImageController {
	
	@Inject
	PostService postService;
	
	@Inject
	UploadController uploadController;
	
	private PostDto currentPost;
	private Part file;
	
	public InputStream getImage(Long id) {
		if (id != null) {
			PostDto post = postService.getPostById(id);
			byte[] image = post != null && post.getImage() != null ? post.getImage() : new byte[]{};
			return new ByteArrayInputStream(image);
		} else {
			return new ByteArrayInputStream(new byte[]{});
		}
	}
	
	public InputStream fetchCurrentImage() {
		if (currentPost != null && currentPost.getId() != null) {
			PostDto post = postService.getPostById(currentPost.getId());
			byte[] image = post != null && post.getImage() != null ? post.getImage() : new byte[]{};
			return new ByteArrayInputStream(image);

		} else {
			return new ByteArrayInputStream(new byte[]{});
		}
	}
	
}
