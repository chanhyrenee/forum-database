package com.exercise.exercise3.demo_exercise3.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exercise.exercise3.demo_exercise3.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

 Optional<List<CommentEntity>> findByPostEntityPostId(Long postId);

}
