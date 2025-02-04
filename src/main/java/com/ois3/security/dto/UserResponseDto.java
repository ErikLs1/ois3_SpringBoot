package com.ois3.security.dto;

import com.ois3.security.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String username;
    private String email;
    private Set<Role> roles;
}
