package com.exercise.exercise3.demo_exercise3.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.exercise.exercise3.demo_exercise3.controller.PostOperation;
import com.exercise.exercise3.demo_exercise3.entity.PostEntity;
import com.exercise.exercise3.demo_exercise3.model.Post;
import com.exercise.exercise3.demo_exercise3.service.PostService;

@RestController
public class PostController implements PostOperation {

  @Autowired
  private PostService postService;

  @Override
  public List<PostEntity> readAllPosts() {
    return postService.findAll();
  }

  @Override
  public PostEntity createPostByUserId(Long userId, PostEntity postEntity) {
    return postService.saveByUserId(userId, postEntity);
  }

  @Override
  public List<PostEntity> retrievePostByUserId(Long userId) {
    return postService.findByUserId(userId);
  }

  @Override
  public PostEntity deletePost(Long postId) {
    return postService.deleteById(postId);
  }

  @Override
  public List<Post> getApiPosts() {
    return postService.getApiData();
  }

  @Override
  public List<PostEntity> saveApiPosts() {
    return postService.saveApiDataToDb(getApiPosts());
  }

  @Override
  public void deleteAllPosts() {
    postService.deleteAllDb();
  }

}
