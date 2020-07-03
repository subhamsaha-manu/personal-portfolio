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

/**
 * <h1>User REST controller!</h1>
 * REST Controller which is the entry point to the application.
 *  1.It fetches complete User Details using the email id sent to it as parameter.
 *   And sends the response wrapped in a Response Object.
 *  2.It also calls the Email Service to send mail, with the incoming user details
 * @author  Subham Saha
 * @version 1.0
 * @since   2024-07-03
 */

@Log4j2
@RestController
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    /**
     * API which fetches complete User details from the database via the Service
     * @param email - the details of the particular user.
     * @return Response Object which wraps the status as well as the User details
     */
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

    /**
     * Presently unused. Should be used to handle if a particular picture is liked.
     * @param id The id of the image.
     * @return Status wrapped in Response depending upon whether the operation was carried
     * out successfully.
     */
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


    /**
     * Used to send Email to the user(website owner) with the details sent from the
     * UI App via the contact form.
     * @param mailObject The user details fetched from the contact form.
     * @return Status wrapped in Response depending upon whether the operation was carried
     *         out successfully.
     */
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
