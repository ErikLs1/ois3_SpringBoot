package com.ois3.service.impl;

import com.ois3.dto.TaskGradeDto;
import com.ois3.entity.Enrollment;
import com.ois3.entity.Task;
import com.ois3.entity.TaskGrade;
import com.ois3.entity.Teacher;
import com.ois3.mapper.TaskGradeMapper;
import com.ois3.repository.EnrollmentRepository;
import com.ois3.repository.TaskGradeRepository;
import com.ois3.repository.TaskRepository;
import com.ois3.repository.TeacherRepository;
import com.ois3.service.TaskGradeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskGradeServiceImpl implements TaskGradeService {

    private final TaskGradeRepository taskGradeRepository;
    private final TaskGradeMapper taskGradeMapper;
    private final TaskRepository taskRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final TeacherRepository teacherRepository;

    private TaskGradeDto getTaskGradeDto(TaskGradeDto dto, TaskGrade taskGrade) {
        if (dto.getTaskId() != null) {
            Task task = taskRepository.findById(dto.getTaskId())
                    .orElseThrow(() -> new RuntimeException("Task not found with id: " + dto.getTaskId()));
            taskGrade.setTask(task);
        }

        if (dto.getEnrollmentId() != null) {
            Enrollment enrollment = enrollmentRepository.findById(dto.getEnrollmentId())
                    .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + dto.getEnrollmentId()));
            taskGrade.setEnrollment(enrollment);
        }

        if (dto.getTeacherId() != null) {
            Teacher teacher = teacherRepository.findById(dto.getTeacherId())
                    .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + dto.getTeacherId()));
            taskGrade.setTeacher(teacher);
        }

        TaskGrade updated = taskGradeRepository.save(taskGrade);
        return taskGradeMapper.toDto(updated);
    }

    @Override
    public TaskGradeDto createTaskGrade(TaskGradeDto dto) {
        TaskGrade taskGrade = taskGradeMapper.toEntity(dto);

        return getTaskGradeDto(dto, taskGrade);
    }

    @Override
    public TaskGradeDto updateTaskGrade(Integer id, TaskGradeDto dto) {
        TaskGrade existing = taskGradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TaskGrade not found with id: " + id));

        existing.setTaskGrade(dto.getTaskGrade());
        existing.setGradedAt(dto.getGradedAt());

        return getTaskGradeDto(dto, existing);
    }

    @Override
    public TaskGradeDto getTaskGradeById(Integer id) {
        TaskGrade taskGrade = taskGradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TaskGrade not found with id: " + id));
        return taskGradeMapper.toDto(taskGrade);
    }

    @Override
    public List<TaskGradeDto> getAllTaskGrades() {
        return taskGradeRepository.findAll().stream()
                .map(taskGradeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTaskGrade(Integer id) {
        TaskGrade taskGrade = taskGradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TaskGrade not found with id: " + id));
        taskGradeRepository.deleteById(id);
    }
}
