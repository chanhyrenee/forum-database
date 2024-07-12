package com.exercise.exercise3.demo_exercise3.mapper;

import java.util.ArrayList;
import org.springframework.stereotype.Component;
import com.exercise.exercise3.demo_exercise3.dto.responseDto.AllDataDto;
import com.exercise.exercise3.demo_exercise3.dto.responseDto.AllDataDto.AdderssDto;
import com.exercise.exercise3.demo_exercise3.dto.responseDto.AllDataDto.AdderssDto.GeoDto;
import com.exercise.exercise3.demo_exercise3.dto.responseDto.AllDataDto.CompanyDto;
import com.exercise.exercise3.demo_exercise3.dto.responseDto.AllDataDto.PostDto;
import com.exercise.exercise3.demo_exercise3.dto.responseDto.AllDataDto.PostDto.CommentDto;
import com.exercise.exercise3.demo_exercise3.dto.sqldto.SqlDto;

@Component
public class AllDataDtoMapper {

  public AllDataDto map(SqlDto sqlDto) {
    GeoDto geoDto = GeoDto.builder().lat(sqlDto.getGeoLat())
        .lng(sqlDto.getGeoLng()).build();
    AdderssDto addressDto = AdderssDto.builder()
        .street(sqlDto.getAddressStreet())
        .suite(sqlDto.getAddressSuite()).city(sqlDto.getAddressCity())
        .zipcode(sqlDto.getAddressZipcode()).geoDto(geoDto).build();
    CompanyDto companyDto =
        CompanyDto.builder().name(sqlDto.getCompanyName())
            .catchPhrase(sqlDto.getCompanyCatchPhrase())
            .bs(sqlDto.getCompanyBs()).build();

    return AllDataDto.builder().id(sqlDto.getUserId())
        .name(sqlDto.getName())
        .username(sqlDto.getUsername())
        .email(sqlDto.getEmail()).address(addressDto)
        .phone(sqlDto.getPhone()).website(sqlDto.getWebsite())
        .company(companyDto)
        .posts(new ArrayList<>())
        .build();
  }

  public PostDto mapToPostDto(SqlDto sqlDto) {
    return PostDto.builder().id(sqlDto.getPostId())
        .title(sqlDto.getTitle()).body(sqlDto.getBody())
        .comments(new ArrayList<>())
        .build();
  }

  public CommentDto mapToCommentDto(SqlDto sqlDto) {
    return CommentDto.builder().id(sqlDto.getCommentId())
        .name(sqlDto.getCommentName()).email(sqlDto.getCommentEmail())
        .body(sqlDto.getCommentBody()).build();
  }
}
