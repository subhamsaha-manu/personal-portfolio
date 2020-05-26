package com.personal.portfolio.service;

import com.personal.portfolio.dto.UserDTO;
import com.personal.portfolio.mapper.UserMapper;
import com.personal.portfolio.model.User;
import com.personal.portfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;


    @Override
    public List<UserDTO> findAll() {
        List<User> user = userRepository.findAll();
        UserDTO userDTO = mapper.userToUserDTO(user.get(0));
        return null;
    }
}
