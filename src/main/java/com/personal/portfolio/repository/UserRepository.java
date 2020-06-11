package com.personal.portfolio.repository;

import com.personal.portfolio.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CommonInterface<User,Long> {

   User findByEmailAddresses_value(String email);
}
