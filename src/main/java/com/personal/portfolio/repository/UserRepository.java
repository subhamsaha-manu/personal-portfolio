package com.personal.portfolio.repository;

import com.personal.portfolio.model.Photo;
import com.personal.portfolio.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * <h1>User Repository Interface!</h1>
 * Has the basic methods related to interact with the user collection
 *
 * @author  Subham Saha
 * @version 1.0
 * @since   2024-07-03
 */


@Repository
public interface UserRepository extends CommonInterface<User,Long> {

   /**
    * method to fetch a particular user based on email address
    * @param email
    * @return the User
    */
   User findByEmailAddresses_value(String email);

   /**
    * Presently unused.
    * @param id
    * @return
    */
   Photo findByPhotos_id(int id);
}
