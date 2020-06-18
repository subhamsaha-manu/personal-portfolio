package com.personal.portfolio.controller;


import com.personal.portfolio.dto.model.UserDTO;
import com.personal.portfolio.dto.request.MailObject;
import com.personal.portfolio.dto.response.Response;
import com.personal.portfolio.service.EmailService;
import com.personal.portfolio.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/getUser")
    public Response getUserByEmail(@RequestParam String email ){
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

    @PostMapping("/increaseLikeCounter/{id}")
    public Response increaseLikeCounter(@PathVariable("id") int id) {

        try {
            userService.increaseLikeCounter(id);
            return Response.ok();
        } catch (Exception e) {
            return Response.notFound()
                    .setErrors(String.format("No photo found with - '%s'", id));
        }
    }


    @PostMapping("/sendEmail")
    public Response sendEmail(@RequestBody @Valid MailObject mailObject) {

            String subject =  "Contact From "+mailObject.getFirstName()+" "+mailObject.getLastName();
            String textBody = "Contact Details "+mailObject.getEmail()+" "+mailObject.getMobileNumber();
            String to = "subhamsaha90@gmail.com";
            try{
                emailService.sendSimpleMessage(to,subject,textBody);
                // emailService.sendSimpleMessageUsingTemplate("subhamsaha90@gmail.com","Test Template Subject");
                return Response.ok();
            }catch (Exception e){
                log.info("Mail could not be sent.");
                return Response.error()
                        .setErrors(String.format("Mail could not be sent"));
            }
    }
}
