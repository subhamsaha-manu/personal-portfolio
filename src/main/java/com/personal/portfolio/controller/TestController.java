package com.personal.portfolio.controller;


import com.personal.portfolio.dto.UserDto;
import com.personal.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String first(){
        return "Hello World";
    }

    @GetMapping(value = "/getName")
    public String getName(){
        String email = "subhamsaha90@gmail.com";
        String name = "";
        Optional<UserDto> userDto = Optional.ofNullable(userService.findByEmail(email));
        userService.findAll();
        if(userDto.isPresent()){
            name = userDto.get().getName();
        }
        return name;
    }
}
