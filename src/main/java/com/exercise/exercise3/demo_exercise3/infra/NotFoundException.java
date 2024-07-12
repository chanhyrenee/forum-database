package com.exercise.exercise3.demo_exercise3.infra;

public class NotFoundException extends BusinessRuntimeException {

  public NotFoundException() {
    super(SysCode.NOT_FOUND);
  }
}
