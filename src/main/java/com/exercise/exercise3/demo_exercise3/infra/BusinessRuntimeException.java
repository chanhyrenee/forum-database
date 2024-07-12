package com.exercise.exercise3.demo_exercise3.infra;

import lombok.Getter;

@Getter
public class BusinessRuntimeException extends RuntimeException {
  private String code;

  public BusinessRuntimeException(SysCode code) {
    super(code.getDesc());
    this.code = code.getCode();
  }
}
