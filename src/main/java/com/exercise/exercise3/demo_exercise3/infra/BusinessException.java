package com.exercise.exercise3.demo_exercise3.infra;

import lombok.Getter;

@Getter
public class BusinessException extends Exception {
  private String code;

  public BusinessException(SysCode code) {
    super(code.getDesc());
    this.code = code.getCode();
  }
}
