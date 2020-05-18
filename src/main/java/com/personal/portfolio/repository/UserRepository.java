package com.personal.portfolio.repository;

import com.personal.portfolio.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,Long> {

    List<User> findAll();

    User findByEmail(String email);
}
