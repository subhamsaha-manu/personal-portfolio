package com.personal.portfolio.service;

import com.personal.portfolio.dto.UserDTO;

import java.util.List;

public interface UserService {

   // UserDto findByEmail(String email);

    List<UserDTO> findAll();
}
