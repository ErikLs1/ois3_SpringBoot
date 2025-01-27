package com.ois3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "semester_subject")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SemesterSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer semesterSubjectId;

    @ManyToOne
    @JoinColumn(name = "semester_id", nullable = false)
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @Column(name = "room", length = 50)
    private String room;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;
}
