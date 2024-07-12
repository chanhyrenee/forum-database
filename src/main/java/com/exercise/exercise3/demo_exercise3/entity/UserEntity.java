package com.exercise.exercise3.demo_exercise3.entity;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Member")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserEntity implements Serializable{

  @Id
  private Long userId;
  private String name;
  private String username;
  private String email;
  private String addressStreet;
  private String addressSuite;
  private String addressCity;
  private String addressZipcode;
  private String geoLat;
  private String geoLng;
  private String phone;
  private String website;
  private String companyName;
  private String companyCatchPhrase;
  private String companyBs;

  // @OneToMany(mappedBy = "userEntity", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  // @JsonManagedReference
  // private List<PostEntity> posts = new ArrayList<>();
}
