package com.ois3.controller;

import com.ois3.dto.SubjectDto;
import com.ois3.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/teacher")
public class SubjectController {
    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectDto> createSubject(@RequestBody SubjectDto subjectDto) {
        SubjectDto savedSubject = subjectService.createSubject(subjectDto);
        return new ResponseEntity<>(savedSubject, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SubjectDto> getSubjectById(@PathVariable("id") Integer subjectId) {
        SubjectDto subjectDto = subjectService.getSubjectById(subjectId);
        return ResponseEntity.ok(subjectDto);
    }

    @GetMapping
    public ResponseEntity<List<SubjectDto>> getAllSubjects() {
        List<SubjectDto> subjects = subjectService.getAllSubjects();
        return ResponseEntity.ok(subjects);
    }

    @PutMapping("{id}")
    public ResponseEntity<SubjectDto> updateSubject(@PathVariable("id") Integer subjectId,
                                                    @RequestBody SubjectDto updatedSubject) {
        SubjectDto subjectDto = subjectService.updateSubject(subjectId, updatedSubject);
        return ResponseEntity.ok(subjectDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable("id") Integer subjectId) {
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.ok("Subject deleted successfully!");
    }
}
