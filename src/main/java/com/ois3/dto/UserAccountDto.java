package com.ois3.dto;

import com.ois3.security.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountDto {
    private Integer userAccountId;
    private String username;
    private String email;
    private String password;
    private Boolean enabled;
    private Integer personId;
    private Set<Role> roles; // Delete later
}
