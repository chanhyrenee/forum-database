package com.exercise.exercise3.demo_exercise3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Post {
  private Long userId;
  @JsonProperty(value = "id")
  private Long postId;
  private String title;
  @JsonProperty(value = "body")
  private String postBody;
}
