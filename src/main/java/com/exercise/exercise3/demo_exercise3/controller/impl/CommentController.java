package com.exercise.exercise3.demo_exercise3.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.exercise.exercise3.demo_exercise3.controller.CommentOperation;
import com.exercise.exercise3.demo_exercise3.entity.CommentEntity;
import com.exercise.exercise3.demo_exercise3.model.Comment;
import com.exercise.exercise3.demo_exercise3.service.CommentService;

@RestController
public class CommentController implements CommentOperation{
  
  @Autowired
  private CommentService commentService;

  @Override
  public List<CommentEntity> readAllComments() {
    return commentService.findAll();
  }

  @Override
  public CommentEntity createCommentByPostId(Long postId, CommentEntity commentEntity) {
    return commentService.saveByPostId(postId, commentEntity);
  }

  @Override
  public List<CommentEntity> retrieveCommentByPostId(Long postId) {
    return commentService.findByPostId(postId);
  }

  @Override
  public CommentEntity patch(Long commentId,
      String commentBody) {
    return commentService.save(commentId, commentBody);
  }

  @Override
  public List<Comment> getApiComments() {
    return commentService.getApiData();
  }

  @Override
  public List<CommentEntity> saveApiComments() {
    return commentService.saveApiDataToDb(getApiComments());
  }

  @Override
  public void deleteAllComments() {
    commentService.deleteAllDb();
  }

}
