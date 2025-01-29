package com.ois3.controller;

import com.ois3.dto.SemesterSubjectDto;
import com.ois3.service.SemesterSubjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/semester-subject")
public class SemesterSubjectController {
    private final SemesterSubjectService semesterSubjectService;

    @PostMapping
    public ResponseEntity<SemesterSubjectDto> createSemesterSubject(@RequestBody SemesterSubjectDto semesterSubjectDto) {
        SemesterSubjectDto savedSemesterSubject = semesterSubjectService.createSemesterSubject(semesterSubjectDto);
        return new ResponseEntity<>(savedSemesterSubject, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SemesterSubjectDto> getSemesterSubjectById(@PathVariable("id") Integer semesterSubjectId) {
        SemesterSubjectDto semesterSubjectDto = semesterSubjectService.getSemesterSubjectById(semesterSubjectId);
        return ResponseEntity.ok(semesterSubjectDto);
    }

    @GetMapping
    public ResponseEntity<List<SemesterSubjectDto>> getAllSemesterSubjects() {
        List<SemesterSubjectDto> semesterSubjects = semesterSubjectService.getAllSemesterSubjects();
        return ResponseEntity.ok(semesterSubjects);
    }

    @PutMapping("{id}")
    public ResponseEntity<SemesterSubjectDto> updateSemesterSubject(@PathVariable("id") Integer semesterSubjectId,
                                                                    @RequestBody SemesterSubjectDto updatedSemesterSubject) {
        SemesterSubjectDto semesterSubjectDto = semesterSubjectService.updateSemesterSubject(semesterSubjectId, updatedSemesterSubject);
        return ResponseEntity.ok(semesterSubjectDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSemesterSubject(@PathVariable("id") Integer semesterSubjectId) {
        semesterSubjectService.deleteSemesterSubject(semesterSubjectId);
        return ResponseEntity.ok("SemesterSubject deleted successfully!");
    }
}
