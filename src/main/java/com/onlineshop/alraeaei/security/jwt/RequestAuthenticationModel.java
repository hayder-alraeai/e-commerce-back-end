package com.onlineshop.alraeaei.security.jwt;

import lombok.Value;

@Value
public class RequestAuthenticationModel {
    private String username;
    private String password;
}
