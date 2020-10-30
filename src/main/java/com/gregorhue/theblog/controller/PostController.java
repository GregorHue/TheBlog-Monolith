package com.gregorhue.theblog.controller;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gregorhue.theblog.dto.CommentDto;
import com.gregorhue.theblog.dto.PostDto;
import com.gregorhue.theblog.model.Vote;
import com.gregorhue.theblog.service.CommentService;
import com.gregorhue.theblog.service.PostService;
import com.gregorhue.theblog.service.UserService;

/**
 * Created by gregorhue on 09.10.2020.
 */

@Named
@ViewScoped
public class PostController implements Serializable {

    private static final long serialVersionUID = -6660829277671473823L;

    @Inject
    private CommentService commentService;

    @Inject
    private UserService userService;

    @Inject
    private PostService postService;

    private List<CommentDto> comments;

    private Long postId;

    private PostDto post;

    private CommentDto currentComment;

    private String sortOrder = "newest";

    public void onInit() {
        post = postService.getPostById(postId);
        comments = commentService.getAllCommentsByPostId(postId);

    }

    public CommentDto getComment(Long id) {
        return commentService.getCommentById(id);
    }

    public void createNewComment() {
        currentComment = new CommentDto();
    }

    public void saveNewComment(CommentDto commentDto) {
        commentDto.setAuthorUrl(userService.getUserByUsername("user").getUserUrl());
        if (commentDto.getLikes() == null) {
            commentDto.setLikes(0);
        }
        commentService.saveNewComment(commentDto);
    }

    public void updateComment(Long id, CommentDto commentDto) {
        Long userId = Long.parseLong(commentDto.getAuthorUrl().split("=")[1]);
        commentService.saveComment(id, commentDto);
    }

    private void patchComment(Long id, CommentDto commentDto) {
        commentService.patchComment(id, commentDto);
    }

    public void upvoteComment(CommentDto commentDto) {
        Long commentId = Long.parseLong(commentDto.getCommentUrl().split("=")[1]);
        commentDto.setOption(Vote.UPVOTE);
        patchComment(commentId, commentDto);
    }

    public void downvoteComment(CommentDto commentDto) {
        Long commentId = Long.parseLong(commentDto.getCommentUrl().split("=")[1]);
        commentDto.setOption(Vote.DOWNVOTE);
        patchComment(commentId, commentDto);
        comments = commentService.getAllCommentsByPostId(postId);
    }

    public void deleteComment() {
        Long commentId = Long.parseLong(currentComment.getCommentUrl().split("=")[1]);
        commentService.deleteCommentById(commentId);
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public PostDto getPost() {
        return post;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public CommentDto getCurrentComment() {
        return currentComment;
    }

    public void setCurrentComment(CommentDto currentComment) {
        this.currentComment = currentComment;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public void sort() {
        System.out.println(sortOrder);
    }
}

