package com.ois3.controller;

import com.ois3.dto.TaskGradeDto;
import com.ois3.service.TaskGradeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/task-grade")
public class TaskGradeController {

    private final TaskGradeService taskGradeService;

    @PostMapping
    public ResponseEntity<TaskGradeDto> createTaskGrade(@RequestBody TaskGradeDto taskGradeDto) {
        TaskGradeDto savedTaskGrade = taskGradeService.createTaskGrade(taskGradeDto);
        return new ResponseEntity<>(savedTaskGrade, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskGradeDto> getTaskGradeById(@PathVariable("id") Integer taskGradeId) {
        TaskGradeDto gradeDto = taskGradeService.getTaskGradeById(taskGradeId);
        return ResponseEntity.ok(gradeDto);
    }

    @GetMapping
    public ResponseEntity<List<TaskGradeDto>> getAllTaskGrades() {
        List<TaskGradeDto> taskGrades = taskGradeService.getAllTaskGrades();
        return ResponseEntity.ok(taskGrades);
    }

    @PutMapping("{id}")
    public ResponseEntity<TaskGradeDto> updateTaskGrade(@PathVariable("id") Integer taskGradeId,
                                                        @RequestBody TaskGradeDto updatedTaskGrade) {
        TaskGradeDto taskGradeDto = taskGradeService.updateTaskGrade(taskGradeId, updatedTaskGrade);
        return ResponseEntity.ok(taskGradeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTaskGrade(@PathVariable("id") Integer taskGradeId) {
        taskGradeService.deleteTaskGrade(taskGradeId);
        return ResponseEntity.ok("TaskGrade deleted successfully!");
    }
}
