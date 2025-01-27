package com.ois3.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "semester")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer semesterId;

    @Column(name = "semester_name", length = 50, nullable = false)
    private String semesterName;

    @Column(name = "semester_year")
    private Integer semesterYear;
}
