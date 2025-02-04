package com.ois3.security.dto;

import lombok.Data;

@Data
public class VerifyUserDto {
    private String email;
    private String verificationCode;
}
