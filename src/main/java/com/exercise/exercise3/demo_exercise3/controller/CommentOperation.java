package com.exercise.exercise3.demo_exercise3.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.exercise.exercise3.demo_exercise3.entity.CommentEntity;
import com.exercise.exercise3.demo_exercise3.model.Comment;

public interface CommentOperation {

  @GetMapping(value = "/comments")
  List<CommentEntity> readAllComments();

  @PostMapping(value = "/commentByPostId")
  CommentEntity createCommentByPostId(@RequestParam Long postId,
      @RequestBody CommentEntity commentEntity);

  @GetMapping(value = "/commentByPostId")
  List<CommentEntity> retrieveCommentByPostId(@RequestParam Long postId);

  @PatchMapping(value = "/comment")
  CommentEntity patch(@RequestParam Long commentId,
      @RequestBody String commentBody);

  @GetMapping(value = "getApiComments")
  List<Comment> getApiComments();

  @PostMapping(value = "saveApiComments")
  List<CommentEntity> saveApiComments();

  @DeleteMapping(value = "deleteAllComments")
  void deleteAllComments();
}
