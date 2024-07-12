package com.exercise.exercise3.demo_exercise3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.exercise.exercise3.demo_exercise3.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  // javax.persistence.NonUniqueResultException
  List<UserEntity> findByEmailAndPhone(String email, String phone);

  @Query(value = "SELECT m.user_id, m.username, c.comment_name, c.email, c.comment_body, c.comment_id from member m left join post p on m.user_id = p.user_id left join comment c on p.post_id = c.post_id where m.user_id = :userId", nativeQuery = true)
  List<Object[]> getAllCommentByUser(Long userId);
}
