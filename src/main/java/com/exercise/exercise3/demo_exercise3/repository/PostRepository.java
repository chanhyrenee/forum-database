package com.exercise.exercise3.demo_exercise3.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exercise.exercise3.demo_exercise3.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    Optional<List<PostEntity>> findByUserEntityUserId(Long userId);

}
