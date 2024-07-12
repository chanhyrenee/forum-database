package com.exercise.exercise3.demo_exercise3.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.exercise.exercise3.demo_exercise3.entity.PostEntity;
import com.exercise.exercise3.demo_exercise3.model.Post;
import com.exercise.exercise3.demo_exercise3.repository.UserRepository;

@Component
public class PostEntityMapper {

  @Autowired
  UserRepository userRepository;

  public PostEntity map(Post post) {

    return PostEntity.builder()
        .userEntity(userRepository.findById(post.getUserId()).get())
        .postId(post.getPostId()).title(post.getTitle())
        .body(post.getPostBody()).build();
  }
  
}
