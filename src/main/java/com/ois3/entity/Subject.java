package com.ois3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.logging.Level;

@Entity
@Table(name = "subject")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectId;

    @Column(name = "subject_name", length = 100, nullable = false)
    private String subjectName;

    @Column(name = "subject_code", length = 50, nullable = false)
    private String subjectCode;

    @Column(name = "EAP")
    private Integer EAP;

    @Column(name = "subject_description", length = 1000)
    private String subjectDescription;
}
