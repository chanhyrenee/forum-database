package com.exercise.exercise3.demo_exercise3.infra;

import lombok.Getter;

@Getter
public enum SysCode {
  SUCCESS("0000", "Success."), //
  NOT_FOUND("1001", "No foundings from database."), //
  USERID_INVALID("1002", "User ID input invalid."), //
  RESTTEMPLATE_ERROR("1003", "RestTemplate Error - JsonPlaceHolder."),//
  DATABASE_ERROR("1004", "Database Error."),//
  URL_ERROR("1005", "Url error - 404 not found.");

  private String code;
  private String desc;

  private SysCode(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}
