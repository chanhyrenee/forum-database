package com.exercise.exercise3.demo_exercise3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class User {
  @JsonProperty(value = "id")
  private Long userId;
  private String name;
  private String username;
  private String email;
  private Adderss address;
  private String phone;
  private String website;
  private Company company;

  @Getter
  public static class Adderss {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Getter
    public static class Geo {
      private String lat;
      private String lng;
    }
  }

  @Getter
  public static class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }
}
