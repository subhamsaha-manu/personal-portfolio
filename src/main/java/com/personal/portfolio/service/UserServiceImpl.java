package com.personal.portfolio.service;

import com.personal.portfolio.dto.UserDto;
import com.personal.portfolio.model.User;
import com.personal.portfolio.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto findByEmail(String email) {
        Optional<User> user =  Optional.ofNullable(userRepository.findByEmail(email));
        if(user.isPresent()){
            return modelMapper.map(user.get(), UserDto.class);
        }
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        List<User> user = userRepository.findAll();
        return null;
    }
}
