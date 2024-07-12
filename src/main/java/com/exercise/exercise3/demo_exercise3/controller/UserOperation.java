package com.exercise.exercise3.demo_exercise3.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.exercise.exercise3.demo_exercise3.entity.UserEntity;
import com.exercise.exercise3.demo_exercise3.model.User;

public interface UserOperation {

  @GetMapping(value = "/users")
  List<UserEntity> readAllUsers();

  @PostMapping(value = "/user")
  UserEntity createUser(@RequestBody UserEntity userEntity);

  @PutMapping(value = "/user")
  UserEntity updateUser(@RequestParam Long userId,
      @RequestBody UserEntity userEntity);

  @GetMapping(value = "/user")
  UserEntity retrieveUser(@RequestParam Long userId);

  @DeleteMapping(value = "/user")
  UserEntity deleteUser(@RequestParam Long userId);

  @GetMapping(value = "getApiUsers")
  List<User> getApiUsers();

  @PostMapping(value = "saveApiUsers")
  List<UserEntity> saveApiUsers();

  @DeleteMapping(value = "deleteAllUsers")
  void deleteAllUsers();
}

// {
// "userId": 101,
// "name": "test Leanne Graham",
// "username": "test Bret",
// "email": "test Sincere@april.biz",
// "addressStreet": "test Kulas Light",
// "addressSuite": "test Apt. 556",
// "addressCity": "test Gwenborough",
// "addressZipcode": "test 92998-3874",
// "geoLat": "test -37.3159",
// "geoLng": "test 81.1496",
// "phone": "test 1-770-736-8031 x56442",
// "website": "test hildegard.org",
// "companyName": "test Romaguera-Crona",
// "companyCatchPhrase": "test Multi-layered client-server neural-net",
// "companyBs": "test harness real-time e-markets"
// },
