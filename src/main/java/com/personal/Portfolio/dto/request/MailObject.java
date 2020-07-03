package com.personal.portfolio.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <h1>Request Mail Object!</h1>
 * @author  Subham Saha
 * @version 1.0
 * @since   2024-07-03
 */

@Data
public class MailObject {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Long mobileNumber;
    @Email
    @NotNull
    @Size(min = 1, message = "Please, set an email address to send the message to it")
    private String email;
}
