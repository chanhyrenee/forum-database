package com.exercise.exercise3.demo_exercise3.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.exercise.exercise3.demo_exercise3.entity.CommentEntity;
import com.exercise.exercise3.demo_exercise3.entity.PostEntity;
import com.exercise.exercise3.demo_exercise3.infra.NotFoundException;
import com.exercise.exercise3.demo_exercise3.infra.Protocol;
import com.exercise.exercise3.demo_exercise3.infra.UrlBuilder;
import com.exercise.exercise3.demo_exercise3.mapper.CommentEntityMapper;
import com.exercise.exercise3.demo_exercise3.model.Comment;
import com.exercise.exercise3.demo_exercise3.repository.CommentRepository;
import com.exercise.exercise3.demo_exercise3.repository.PostRepository;
import com.exercise.exercise3.demo_exercise3.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private CommentEntityMapper commentEntityMapper;

  @Value(value = "${api.jsonplaceholder.domain}")
  private String domain;

  @Value(value = "${api.jsonplaceholder.endpoint.comments}")
  private String endpoint;

  @Override
  public List<CommentEntity> findAll() {
    return commentRepository.findAll();
  }

  @Override
  public CommentEntity saveByPostId(Long postId, CommentEntity commentEntity) {
    PostEntity postEntity = postRepository.findById(postId)
        .orElseThrow(() -> new NotFoundException());
        commentEntity.setPostEntity(postEntity);
    return commentRepository.save(commentEntity);
  }


  @Override
  public List<CommentEntity> findByPostId(Long postId) {
    return commentRepository.findByPostEntityPostId(postId)
        .orElseThrow(() -> new NotFoundException());
  }

  @Override
  public CommentEntity save(Long commentId, String commentBody) {
    CommentEntity commentEntity = commentRepository.findById(commentId)
        .orElseThrow(() -> new NotFoundException());
    commentEntity.setCommentBody(commentBody);
    return commentRepository.save(commentEntity);
  }

  @Override
  public List<Comment> getApiData() {
      Comment[] comments = restTemplate.getForObject(
          UrlBuilder.get(Protocol.HTTP, domain, endpoint), Comment[].class);
      return Arrays.asList(comments);
  }

  @Override
  public List<CommentEntity> saveApiDataToDb(List<Comment> comments) {
    List<CommentEntity> commentEntities = comments.stream()
        .map(x -> commentEntityMapper.map(x)).collect(Collectors.toList());
    return commentRepository.saveAll(commentEntities);
  }

  @Override
  public void deleteAllDb() {
    commentRepository.deleteAll();
  }

}
