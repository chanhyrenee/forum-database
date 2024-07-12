package com.exercise.exercise3.demo_exercise3.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.exercise.exercise3.demo_exercise3.controller.UserOperation;
import com.exercise.exercise3.demo_exercise3.entity.UserEntity;
import com.exercise.exercise3.demo_exercise3.model.User;
import com.exercise.exercise3.demo_exercise3.service.UserService;

@RestController
public class UserController implements UserOperation {

  @Autowired
  private UserService userService;

  @Override
  public List<UserEntity> readAllUsers() {
    return userService.findAll();
  }

  @Override
  public UserEntity createUser(UserEntity userEntity) {
    return userService.save(userEntity);
  }

  @Override
  public UserEntity updateUser(@RequestParam Long userId,
      @RequestBody UserEntity userEntity) {
    return userService.save(userId, userEntity);
  }

  @Override
  public UserEntity retrieveUser(Long userId) {
    return userService.findbyId(userId);
  }

  @Override
  public UserEntity deleteUser(Long userId) {
    return userService.deleteById(userId);
  }

  @Override
  public List<User> getApiUsers() {
    return userService.getApiData();
  }

  @Override
  public List<UserEntity> saveApiUsers() {
    return userService.saveApiDataToDB(getApiUsers());
  }

  @Override
  public void deleteAllUsers() {
    userService.deleteAllDb();
  }

}
