package com.softWalter.solicitation.presentations.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter @Setter
@AllArgsConstructor
public class UserLoginDTO {
    @Email(message = "Invalid email")
    private String email;
    @NotBlank(message = "Password required")
    private String password;
}
