package com.exercise.exercise3.demo_exercise3.dto.sqldto;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SqlResultSetMapping(name = "AllDataMapping",
    classes = @ConstructorResult(targetClass = SqlDto.class, columns = {//
        @ColumnResult(name = "userId", type = Long.class),
        @ColumnResult(name = "name", type = String.class),
        @ColumnResult(name = "username", type = String.class),
        @ColumnResult(name = "email", type = String.class),
        @ColumnResult(name = "addressStreet", type = String.class),
        @ColumnResult(name = "addressSuite", type = String.class),
        @ColumnResult(name = "addressCity", type = String.class),
        @ColumnResult(name = "addressZipcode", type = String.class),
        @ColumnResult(name = "geoLat", type = String.class),
        @ColumnResult(name = "geoLng", type = String.class),
        @ColumnResult(name = "phone", type = String.class),
        @ColumnResult(name = "website", type = String.class),
        @ColumnResult(name = "companyName", type = String.class),
        @ColumnResult(name = "companyCatchPhrase", type = String.class),
        @ColumnResult(name = "companyBs", type = String.class),
        @ColumnResult(name = "postId", type = Long.class),
        @ColumnResult(name = "title", type = String.class),
        @ColumnResult(name = "body", type = String.class),
        @ColumnResult(name = "commentId", type = Long.class),
        @ColumnResult(name = "commentName", type = String.class),
        @ColumnResult(name = "commentEmail", type = String.class),
        @ColumnResult(name = "commentBody", type = String.class)}))

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SqlDto {
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
  private Long postId;
  private String title;
  private String body;
  private Long commentId;
  private String commentName;
  private String commentEmail;
  private String commentBody;
}