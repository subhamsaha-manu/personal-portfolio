package com.personal.portfolio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * <h1>Common Interface which extends the MongoRepository!</h1>
 * @author  Subham Saha
 * @version 1.0
 * @since   2024-07-03
 */

@NoRepositoryBean
public interface CommonInterface<T,ID extends Serializable> extends MongoRepository<T,ID> {


}
