package com.ois3.security.dto;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String email;
    private String password;
    private String username;
}
