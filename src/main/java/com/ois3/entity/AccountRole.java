package com.ois3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account_role")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountRoleId;

    @Column(name = "role_name", length = 50, nullable = false)
    private String roleName;

    @Column(name = "description")
    private String description;
}
