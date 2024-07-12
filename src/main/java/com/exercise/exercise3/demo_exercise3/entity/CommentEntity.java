package com.exercise.exercise3.demo_exercise3.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Comment")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CommentEntity implements Serializable{

  @ManyToOne
  @JoinColumn(name = "post_id")
  private PostEntity postEntity;
  @Id
  private Long commentId;
  private String commentName;
  private String email;
  @Column(length = 500)
  private String commentBody;

}
