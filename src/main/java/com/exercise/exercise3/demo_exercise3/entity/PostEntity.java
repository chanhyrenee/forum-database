package com.exercise.exercise3.demo_exercise3.entity;

import java.io.Serializable;
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
@Table(name = "Post")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PostEntity implements Serializable{

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity userEntity;
  @Id
  private Long postId;
  private String title;
  private String body;

  // @OneToMany(mappedBy = "postEntity", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  // @JsonManagedReference
  // private List<PostEntity> posts = new ArrayList<>();
}
