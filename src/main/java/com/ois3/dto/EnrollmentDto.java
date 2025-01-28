package com.ois3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDto {
    private Integer enrollmentId;
    private Integer studentId;
    private Integer semesterSubjectId;
    private Double finalGrade;
    private String status;
    private LocalDateTime enrollmentDate;
}
