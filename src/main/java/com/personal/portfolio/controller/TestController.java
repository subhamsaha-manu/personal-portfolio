package com.personal.portfolio.controller;


import com.personal.portfolio.dto.model.UserDTO;
import com.personal.portfolio.dto.response.Response;
import com.personal.portfolio.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@Slf4j
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String first(){
        return "Hello World";
    }

    @GetMapping(value = "/getName")
    public Response getName(@RequestParam String email ){
        //String email = "subhamsaha90@gmail.com";
        System.out.println("Email "+email);
        log.info("Email address "+email);
        //Optional<UserDto> userDto = Optional.ofNullable(userService.findByEmail(email));
        //userService.findAll();
         Optional<UserDTO> userDTO = Optional.ofNullable(userService.findByEmail(email));
            if(userDTO.isPresent()){
                log.info("User found with - '%s'", email);
                return Response.ok().setPayLoad(userDTO.get());
            }
                log.info("No user found with - '%s'", email);
                return Response.notFound()
                        .setErrors(String.format("No user found with - '%s'", email));
    }
}
