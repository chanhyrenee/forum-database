package com.exercise.exercise3.demo_exercise3.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.exercise.exercise3.demo_exercise3.entity.UserEntity;
import com.exercise.exercise3.demo_exercise3.infra.NotFoundException;
import com.exercise.exercise3.demo_exercise3.infra.Protocol;
import com.exercise.exercise3.demo_exercise3.infra.UrlBuilder;
import com.exercise.exercise3.demo_exercise3.mapper.UserEntityMapper;
import com.exercise.exercise3.demo_exercise3.model.User;
import com.exercise.exercise3.demo_exercise3.repository.UserRepository;
import com.exercise.exercise3.demo_exercise3.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserEntityMapper userEntityMapper;

  @Value(value = "${api.jsonplaceholder.domain}")
  private String domain;

  @Value(value = "${api.jsonplaceholder.endpoint.users}")
  private String endpoint;

  @Override
  public List<UserEntity> findAll() {
    return userRepository.findAll();
  }

  @Override
  public UserEntity save(UserEntity userEntity) {
    return userRepository.save(userEntity);
  }

  @Override
  public UserEntity save(Long userId, UserEntity userEntity) {
    userRepository.findById(userId).orElseThrow(() -> new NotFoundException());
    return userRepository.save(userEntity);
  }

  @Override
  public UserEntity findbyId(Long userId) {
    return userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException());
  }

  @Override
  public UserEntity deleteById(Long userId) {
    UserEntity userEntity = userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException());
    userRepository.deleteById(userId);
    return userEntity;
  }

  @Override
  public List<User> getApiData() {
      User[] users = restTemplate.getForObject(
          UrlBuilder.get(Protocol.HTTP, domain, endpoint), User[].class);
      return Arrays.asList(users);
  }

  @Override
  public List<UserEntity> saveApiDataToDB(List<User> users) {
    List<UserEntity> userEntities = users.stream()
        .map(x -> userEntityMapper.map(x)).collect(Collectors.toList());
    return userRepository.saveAll(userEntities);
  }

  @Override
  public void deleteAllDb() {
    userRepository.deleteAll();
  }

}
