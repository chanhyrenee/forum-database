package com.exercise.exercise3.demo_exercise3.infra;

public class UserIdInvalidException extends BusinessRuntimeException {

  public UserIdInvalidException() {
    super(SysCode.USERID_INVALID);
  }
}
