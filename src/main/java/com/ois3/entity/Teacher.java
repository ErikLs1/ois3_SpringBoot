package com.ois3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "teacher")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Column(name = "department", length = 100)
    private String department;

    @Column(name = "hire_date")
    private LocalDate hireDate;
}
