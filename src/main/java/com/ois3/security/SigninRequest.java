package com.ois3.security;

import lombok.Data;

@Data
public class SigninRequest {
    private String username;
    private String password;
}
