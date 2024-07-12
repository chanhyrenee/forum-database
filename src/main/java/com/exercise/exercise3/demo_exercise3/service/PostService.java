package com.exercise.exercise3.demo_exercise3.service;

import java.util.List;
import com.exercise.exercise3.demo_exercise3.entity.PostEntity;
import com.exercise.exercise3.demo_exercise3.model.Post;

public interface PostService {

  List<PostEntity> findAll();

  PostEntity saveByUserId(Long userId, PostEntity postEntity);

  List<PostEntity> findByUserId(Long userId);

  PostEntity deleteById(Long postId);

  List<Post> getApiData();

  List<PostEntity> saveApiDataToDb(List<Post> posts);

  void deleteAllDb();

}
