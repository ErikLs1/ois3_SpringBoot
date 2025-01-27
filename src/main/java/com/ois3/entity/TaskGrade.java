package com.ois3.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "task_grade")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskGradeId;

    @ManyToOne
    @JoinColumn(name ="task_id", nullable = false)
    private Task task;

    @ManyToOne
    @JoinColumn(name ="enrollment_id", nullable = false)
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(name ="teacher_id")
    private Teacher teacher;

    @Column(name = "task_grade")
    private Integer taskGrade;

    @Column(name = "graded_at")
    private LocalDateTime gradedAt;
}
