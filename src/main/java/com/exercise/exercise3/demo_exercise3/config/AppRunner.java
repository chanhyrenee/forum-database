package com.exercise.exercise3.demo_exercise3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.exercise.exercise3.demo_exercise3.service.CommentService;
import com.exercise.exercise3.demo_exercise3.service.PostService;
import com.exercise.exercise3.demo_exercise3.service.UserService;

@Component
public class AppRunner implements CommandLineRunner {

  @Autowired
  private UserService userService;
  @Autowired
  private PostService postService;
  @Autowired
  private CommentService commentService;

  @Override
  public void run(String... args) {
    userService.saveApiDataToDB(userService.getApiData());
    postService.saveApiDataToDb(postService.getApiData());
    commentService.saveApiDataToDb(commentService.getApiData());
  }

}
