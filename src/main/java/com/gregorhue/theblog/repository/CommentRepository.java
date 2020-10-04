package com.gregorhue.theblog.repository;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.gregorhue.theblog.model.Comment;

/**
 * Created by gregorhue on 04.10.2020.
 */
@SessionScoped
public class CommentRepository extends AbstractRepository<Comment> implements Serializable {

	private static final long serialVersionUID = 8515594387853447614L;

	@Named
	@Produces
	public CommentRepository producesCommentRepository() {
		CommentRepository commentRepository = new CommentRepository();
		commentRepository.setClazz(Comment.class);
		return commentRepository;
	}
}
