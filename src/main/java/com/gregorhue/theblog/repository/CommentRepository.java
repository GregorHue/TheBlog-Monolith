package com.gregorhue.theblog.repository;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import com.gregorhue.theblog.model.Comment;

/**
 * Created by gregorhue on 04.10.2020.
 */
@RequestScoped
public class CommentRepository extends AbstractRepository<Comment> implements Serializable {

	private static final long serialVersionUID = 8515594387853447614L;

	public CommentRepository() {
		setClazz(Comment.class);
	}

	public List<Comment> findAllByPostId(Long postId) {
		List<Comment> comments = entityManager.createQuery("select comm from Comment comm where comm.post.id=:id", Comment.class)
				.setParameter("id", postId)
				.getResultList();
		return comments;
	}
}
