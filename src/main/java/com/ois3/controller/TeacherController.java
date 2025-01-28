package com.ois3.controller;

import com.ois3.dto.TeacherDto;
import com.ois3.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto teacherDto) {
        TeacherDto savedTeacher = teacherService.createTeacher(teacherDto);
        return new ResponseEntity<>(savedTeacher, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable("id") Integer teacherId) {
        TeacherDto teacherDto = teacherService.getTeacherById(teacherId);
        return ResponseEntity.ok(teacherDto);
    }

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllTeachers() {
        List<TeacherDto> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @PutMapping("{id}")
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable("id") Integer teacherId,
                                                    @RequestBody TeacherDto updatedTeacher) {
        TeacherDto teacherDto = teacherService.updateTeacher(teacherId, updatedTeacher);
        return ResponseEntity.ok(teacherDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable("id") Integer teacherId) {
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.ok("Teacher deleted successfully!");
    }
}
