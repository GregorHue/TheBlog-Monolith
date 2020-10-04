package com.gregorhue.theblog.repository;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.gregorhue.theblog.model.Comment;

/**
 * Created by gregorhue on 04.10.2020.
 */
@SessionScoped
public class CommentRepository extends AbstractRepository<Comment> {

	@Named
	@Produces
	public CommentRepository producesCommentRepository() {
		CommentRepository commentRepository = new CommentRepository();
		commentRepository.setClazz(Comment.class);
		return commentRepository;
	}
}
