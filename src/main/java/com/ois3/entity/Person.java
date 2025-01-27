package com.ois3.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personId;

    @Column(name = "uni_id", unique = true, length = 50)
    private String uniId;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
}
