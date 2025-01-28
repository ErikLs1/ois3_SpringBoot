package com.ois3.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountRoleDto {
    private Integer accountRoleId;
    private String roleName;
    private String description;
}
