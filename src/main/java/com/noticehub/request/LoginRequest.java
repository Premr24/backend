package com.noticehub.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    //DTO for login email/password
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

}
