package com.personal.portfolio.service;

import com.personal.portfolio.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto findByEmail(String email);

    List<UserDto> findAll();
}
