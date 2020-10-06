package com.gregorhue.theblog.repository;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import com.gregorhue.theblog.model.Post;

/**
 * Created by gregorhue on 04.10.2020.
 */
@RequestScoped
public class PostRepository extends AbstractRepository<Post> implements Serializable {
	
	private static final long serialVersionUID = -3857966746349277237L;

	public PostRepository() {
		setClazz(Post.class);
	}

}
