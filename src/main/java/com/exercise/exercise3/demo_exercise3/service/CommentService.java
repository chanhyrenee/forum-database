package com.exercise.exercise3.demo_exercise3.service;

import java.util.List;
import com.exercise.exercise3.demo_exercise3.entity.CommentEntity;
import com.exercise.exercise3.demo_exercise3.model.Comment;

public interface CommentService {

  List<CommentEntity> findAll();

  CommentEntity saveByPostId(Long postId, CommentEntity commentEntity);

  List<CommentEntity> findByPostId(Long postId);

  CommentEntity save(Long commentId, String commentBody);

  List<Comment> getApiData();

  List<CommentEntity> saveApiDataToDb(List<Comment> comments);

  void deleteAllDb();

}
