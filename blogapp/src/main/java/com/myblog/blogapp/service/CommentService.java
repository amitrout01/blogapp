package com.myblog.blogapp.service;

import com.myblog.blogapp.entity.Comment;
import com.myblog.blogapp.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId,CommentDto commentDto);
    List<CommentDto> findByPostId(long postId);

    CommentDto updateComments(long postId, long id, CommentDto commentDto);

    void deleteComment(long postId, long id);
}
