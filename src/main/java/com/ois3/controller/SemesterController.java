package com.ois3.controller;

import com.ois3.dto.SemesterDto;
import com.ois3.service.SemesterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/semester")
public class SemesterController {

    private final SemesterService semesterService;

    @PostMapping
    public ResponseEntity<SemesterDto> createSemester(@RequestBody SemesterDto semesterDto) {
        SemesterDto savedSemester = semesterService.createSemester(semesterDto);
        return new ResponseEntity<>(savedSemester, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SemesterDto> getSemesterById(@PathVariable("id") Integer semesterId) {
        SemesterDto semesterDto = semesterService.getSemesterById(semesterId);
        return ResponseEntity.ok(semesterDto);
    }

    @GetMapping
    public ResponseEntity<List<SemesterDto>> getAllSemesters() {
        List<SemesterDto> semesters = semesterService.getAllSemesters();
        return ResponseEntity.ok(semesters);
    }

    @PutMapping("{id}")
    public ResponseEntity<SemesterDto> updateSemester(@PathVariable("id") Integer semesterId,
                                                      @RequestBody SemesterDto updatedSemester) {
        SemesterDto semesterDto = semesterService.updateSemester(semesterId, updatedSemester);
        return ResponseEntity.ok(semesterDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSemester(@PathVariable("id") Integer semesterId) {
        semesterService.deleteSemester(semesterId);
        return ResponseEntity.ok("Semester deleted successfully!");
    }
}
