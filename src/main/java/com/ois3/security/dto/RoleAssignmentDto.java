package com.ois3.security.dto;

import com.ois3.security.model.Role;
import lombok.Data;

@Data
public class RoleAssignmentDto {
    private String email;
    private Role role;
}
