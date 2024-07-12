package com.exercise.exercise3.demo_exercise3.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.exercise.exercise3.demo_exercise3.entity.PostEntity;
import com.exercise.exercise3.demo_exercise3.entity.UserEntity;
import com.exercise.exercise3.demo_exercise3.infra.NotFoundException;
import com.exercise.exercise3.demo_exercise3.infra.Protocol;
import com.exercise.exercise3.demo_exercise3.infra.UrlBuilder;
import com.exercise.exercise3.demo_exercise3.mapper.PostEntityMapper;
import com.exercise.exercise3.demo_exercise3.model.Post;
import com.exercise.exercise3.demo_exercise3.repository.PostRepository;
import com.exercise.exercise3.demo_exercise3.repository.UserRepository;
import com.exercise.exercise3.demo_exercise3.service.PostService;

@Service
public class PostServiceImpl implements PostService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostEntityMapper postEntityMapper;

  @Value(value = "${api.jsonplaceholder.domain}")
  private String domain;

  @Value(value = "${api.jsonplaceholder.endpoint.posts}")
  private String endpoint;

  @Override
  public List<PostEntity> findAll() {
    return postRepository.findAll();
  }

  @Override
  public PostEntity saveByUserId(Long userId, PostEntity postEntity) {
    UserEntity userEntity = userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException());
    postEntity.setUserEntity(userEntity);
    return postRepository.save(postEntity);
  }

  @Override
  public List<PostEntity> findByUserId(Long userId) {
    return postRepository.findByUserEntityUserId(userId)
        .orElseThrow(() -> new NotFoundException());
  }

  @Override
  public PostEntity deleteById(Long postId) {
    PostEntity postEntity = postRepository.findById(postId)
        .orElseThrow(() -> new NotFoundException());
    postRepository.deleteById(postId);
    return postEntity;
  }

  @Override
  public List<Post> getApiData() {
      Post[] posts = restTemplate.getForObject(
          UrlBuilder.get(Protocol.HTTP, domain, endpoint), Post[].class);
      return Arrays.asList(posts);
  }

  @Override
  public List<PostEntity> saveApiDataToDb(List<Post> posts) {
    List<PostEntity> postEntities = posts.stream()
        .map(x -> postEntityMapper.map(x)).collect(Collectors.toList());
    return postRepository.saveAll(postEntities);
  }

  @Override
  public void deleteAllDb() {
    postRepository.deleteAll();
  }

}
