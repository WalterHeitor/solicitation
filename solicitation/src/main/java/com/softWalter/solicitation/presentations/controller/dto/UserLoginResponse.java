package com.softWalter.solicitation.presentations.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
@Getter
@AllArgsConstructor
public class UserLoginResponse implements Serializable {

    private String token;
    private Long expireIn;
    private String tokenProvider;
}
