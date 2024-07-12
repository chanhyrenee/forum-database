package com.exercise.exercise3.demo_exercise3.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.exercise.exercise3.demo_exercise3.entity.PostEntity;
import com.exercise.exercise3.demo_exercise3.model.Post;

public interface PostOperation {

  @GetMapping(value = "/posts")
  List<PostEntity> readAllPosts();

  @PostMapping(value = "/postByUserId/{userId}")
  PostEntity createPostByUserId(@PathVariable Long userId,
      @RequestBody PostEntity postEntity);

  @GetMapping(value = "/postByUserId/{userId}")
  List<PostEntity> retrievePostByUserId(@PathVariable Long userId);

  @DeleteMapping(value = "/post")
  PostEntity deletePost(@RequestParam Long postId);

  @GetMapping(value = "getApiPosts")
  List<Post> getApiPosts();

  @PostMapping(value = "saveApiPosts")
  List<PostEntity> saveApiPosts();

  @DeleteMapping(value = "deleteAllPosts")
  void deleteAllPosts();
}
