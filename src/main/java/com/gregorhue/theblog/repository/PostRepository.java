package com.gregorhue.theblog.repository;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.gregorhue.theblog.model.Post;

/**
 * Created by gregorhue on 04.10.2020.
 */
@SessionScoped
public class PostRepository extends AbstractRepository<Post> implements Serializable {
	
	private static final long serialVersionUID = -3857966746349277237L;

	@Named
	@Produces
	public PostRepository producesPostRepository() {
		PostRepository postRepository = new PostRepository();
		postRepository.setClazz(Post.class);
		return postRepository;
	}

}
