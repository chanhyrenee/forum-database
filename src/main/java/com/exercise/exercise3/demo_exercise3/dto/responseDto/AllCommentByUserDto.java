package com.exercise.exercise3.demo_exercise3.dto.responseDto;

import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class AllCommentByUserDto {
  private Long id;
  private String username;
  private List<CommentsOfUser> comments;

  @Builder
  @Getter
  @EqualsAndHashCode
  public static class CommentsOfUser {
    private String name;
    private String email;
    private String body;
  }
}
