package com.ois3.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDto {
    private String token;
    private long expiresIn;
    private UserResponseDto user;
}
