package com.onlineshop.alraeaei.security.jwt;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Value;
@Value
public class RequestAuthenticationModel {
    private String username;
    private String password;

}
