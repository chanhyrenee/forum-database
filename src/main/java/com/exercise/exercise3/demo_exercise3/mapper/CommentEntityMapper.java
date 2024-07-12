package com.exercise.exercise3.demo_exercise3.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.exercise.exercise3.demo_exercise3.entity.CommentEntity;
import com.exercise.exercise3.demo_exercise3.model.Comment;
import com.exercise.exercise3.demo_exercise3.repository.PostRepository;

@Component
public class CommentEntityMapper {

  @Autowired
  PostRepository postRepository;

  public CommentEntity map(Comment comment) {
    return CommentEntity.builder()
        .postEntity(postRepository.findById(comment.getPostId()).get())
        .commentId(comment.getCommentId()).commentName(comment.getCommentName())
        .email(comment.getEmail()).commentBody(comment.getCommentBody())
        .build();
  }
}
