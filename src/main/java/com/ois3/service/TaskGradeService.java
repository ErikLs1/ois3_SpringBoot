package com.ois3.service;

import com.ois3.dto.TaskGradeDto;

import java.util.List;

public interface TaskGradeService {

    TaskGradeDto createTaskGrade(TaskGradeDto dto);

    TaskGradeDto updateTaskGrade(Integer id, TaskGradeDto dto);

    TaskGradeDto getTaskGradeById(Integer id);

    List<TaskGradeDto> getAllTaskGrades();

    void deleteTaskGrade(Integer id);
}
