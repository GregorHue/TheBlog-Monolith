package com.gregorhue.theblog.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.gregorhue.theblog.dto.CommentDto;
import com.gregorhue.theblog.mapper.CommentMapper;
import com.gregorhue.theblog.model.Comment;
import com.gregorhue.theblog.model.Post;
import com.gregorhue.theblog.model.User;
import com.gregorhue.theblog.model.Vote;
import com.gregorhue.theblog.repository.CommentRepository;
import com.gregorhue.theblog.repository.PostRepository;
import com.gregorhue.theblog.repository.UserRepository;
import com.gregorhue.theblog.service.CommentService;

/**
 * Created by gregorhue on 06.10.2020.
 */
@Stateless
public class CommentServiceImpl implements CommentService {

	@Inject
	private UserRepository userRepository;
	@Inject
	private CommentRepository commentRepository;
	@Inject
	private PostRepository postRepository;
	@Inject
	private CommentMapper commentMapper;

	@Override
	public List<CommentDto> getAllCommentsByPostId(Long postId) {
		List<Comment> comments = commentRepository.findAllByPostId(postId);
		comments.forEach(comment -> comment.setAuthorname(comment.getAuthor().getUsername()));
		return commentMapper.toCommentDtos(comments);
	}

	@Override
	public CommentDto getCommentById(Long id) {
		Comment comment = commentRepository.findOne(id);
		if (comment != null) {
			comment.setAuthorname(comment.getAuthor().getUsername());
		}
		return commentMapper.toCommentDto(comment);
	}

	@Override
	public void saveNewComment(CommentDto commentDto) {
		Comment comment = commentMapper.toComment(commentDto);
		comment.setCreatedAt(LocalDateTime.now());
		processCommentDto(commentDto, comment);
		commentRepository.saveNewEntity(comment);
	}

	@Override
	public void updateComment(Long id, CommentDto commentDto) {
		Comment comment = commentMapper.toComment(commentDto);
		comment.setLastUpdatedAt(LocalDateTime.now());
		comment.setId(id);
		processCommentDto(commentDto, comment);
		commentRepository.updateEntry(comment);
	}

	private void processCommentDto(CommentDto commentDto, Comment comment) {
		Long postId = Long.parseLong(commentDto.getPostUrl().split("=")[1]);
		Post post = postRepository.findOne(postId);
		comment.setPost(post);
		Long authorId = Long.parseLong(commentDto.getAuthorUrl().split("=")[1]);
		User author = userRepository.findOne(authorId);
		comment.setAuthor(author);
		comment.setAuthorname(comment.getAuthor().getUsername());
	}

	@Override
	public void patchComment(Long id, CommentDto commentDto) {
		Comment comment = commentRepository.findOne(id);
		if (comment != null && commentDto.getOption() != null) {
			if (commentDto.getOption() == Vote.UPVOTE) {
				comment.setLikes(comment.getLikes() + 1);
			} else {
				comment.setLikes(comment.getLikes() - 1);
			}
			commentRepository.updateEntry(comment);
			commentMapper.toCommentDto(comment);
		}			
	}

	@Override
	public void deleteCommentById(Long id) {
		commentRepository.deleteById(id);
	}

}
