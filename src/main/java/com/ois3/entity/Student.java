package com.ois3.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @OneToOne
    @JoinColumn(name ="person_id", nullable = false)
    private Person person;

    @Column(name = "program", length = 100)
    private String program;

    @Column(name = "start_year")
    private Integer startYear;
}
