package com.personal.portfolio.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
