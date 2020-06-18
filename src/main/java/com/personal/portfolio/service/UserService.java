package com.personal.portfolio.service;

import com.personal.portfolio.dto.model.UserDTO;

import java.util.List;

public interface UserService {

   UserDTO findByEmail(String email);

    List<UserDTO> findAll();

    void increaseLikeCounter(int id);

}
