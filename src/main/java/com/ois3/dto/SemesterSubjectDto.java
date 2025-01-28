package com.ois3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SemesterSubjectDto {
    private Integer semesterSubjectId;
    private Integer semesterId;
    private Integer subjectId;
    private Integer teacherId;
    private String room;
    private LocalDate startDate;
    private LocalDate endDate;
}
