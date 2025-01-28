package com.ois3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountDto {
    private Integer userAccountId;
    private Integer personId;
    private Integer accountRoleId;
    private String username;
    private String password; // Delete later
}
