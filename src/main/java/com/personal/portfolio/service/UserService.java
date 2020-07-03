package com.personal.portfolio.service;

import com.personal.portfolio.dto.model.UserDTO;

import java.util.List;

/**
 * <h1>User service interface!</h1>
 * @author  Subham Saha
 * @version 1.0
 * @since   2024-07-03
 */

public interface UserService {

   UserDTO findByEmail(String email);

    List<UserDTO> findAll();

    void increaseLikeCounter(int id);

}
