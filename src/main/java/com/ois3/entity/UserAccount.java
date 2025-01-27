package com.ois3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_account")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userAccountId;

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "account_role_id", nullable = false)
    private AccountRole accountRole;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;
}
