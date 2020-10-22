package com.gregorhue.theblog.repository;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

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
	
	public List<Post> findAllByAuthorId(Long authorId) {
		List<Post> posts = entityManager.createQuery("select p from Post p where p.author.id =:id", Post.class)
				.setParameter("id", authorId)
				.getResultList();
		return posts;
	}

}













































