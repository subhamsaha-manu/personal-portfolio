package com.personal.portfolio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface CommonInterface<T,ID extends Serializable> extends MongoRepository<T,ID> {


}
