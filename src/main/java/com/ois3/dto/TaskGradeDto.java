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
public class TaskGradeDto {
    private Integer taskGradeId;
    private Integer taskId;
    private Integer enrollmentId;
    private Integer teacherId;
    private Integer taskGrade;
    private LocalDateTime gradedAt;
}
