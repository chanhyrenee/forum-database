package com.exercise.exercise3.demo_exercise3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Comment {
  private Long postId;
  @JsonProperty(value = "id")
  private Long commentId;
  @JsonProperty(value = "name")
  private String commentName;
  private String email;
  @JsonProperty(value = "body")
  private String commentBody;
}
