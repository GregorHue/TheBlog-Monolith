package com.gregorhue.theblog.repository;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.gregorhue.theblog.model.Post;

/**
 * Created by gregorhue on 04.10.2020.
 */
@SessionScoped
public class PostRepository extends AbstractRepository<Post> {
	
	@Named
	@Produces
	public PostRepository producesPostRepository() {
		PostRepository postRepository = new PostRepository();
		postRepository.setClazz(Post.class);
		return postRepository;
	}

}
