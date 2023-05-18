package com.example.thefirstspringboot.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class LoginResponseDto {
    @JsonProperty("access_token")
    private String accessToken;
}
