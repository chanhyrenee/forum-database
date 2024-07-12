package com.exercise.exercise3.demo_exercise3.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.exercise.exercise3.demo_exercise3.dto.sqldto.SqlDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class AllDataRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @SuppressWarnings("unchecked")
  public List<SqlDto> getAllData() {
    String sql = "SELECT m.user_id, m.name, m.username, m.email, "//
        + "m.address_street, m.address_suite, m.address_city, m.address_zipcode, "//
        + "m.geo_lat, m.geo_lng, m.phone, m.website, m.company_name, m.company_catch_phrase, m.company_bs, "//
        + "p.post_id, p.title, p.body, "//
        + "c.comment_id, c.comment_name, c.email, c.comment_body "//
        + "FROM member m LEFT JOIN post p ON m.user_id = p.user_id "
        + "LEFT JOIN comment c ON p.post_id = c.post_id ";

    Query query = entityManager.createNativeQuery(sql, SqlDto.class);

    return query.getResultList();
  }
}
