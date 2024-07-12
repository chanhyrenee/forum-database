package com.exercise.exercise3.demo_exercise3.service;

import java.util.List;
import com.exercise.exercise3.demo_exercise3.entity.UserEntity;
import com.exercise.exercise3.demo_exercise3.model.User;

public interface UserService {

  List<UserEntity> findAll();

  UserEntity save(UserEntity userEntity);

  UserEntity save(Long userId, UserEntity userEntity);

  UserEntity findbyId(Long userId);

  UserEntity deleteById(Long userId);

  List<User> getApiData();

  List<UserEntity> saveApiDataToDB(List<User> users);

  void deleteAllDb();

}
