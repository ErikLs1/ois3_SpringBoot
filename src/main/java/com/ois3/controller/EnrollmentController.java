package com.ois3.controller;

import com.ois3.dto.EnrollmentDto;
import com.ois3.entity.Enrollment;
import com.ois3.service.EnrollmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentDto> createEnrollment(@RequestBody EnrollmentDto enrollmentDto) {
        EnrollmentDto savedEnrollment = enrollmentService.createEnrollment(enrollmentDto);
        return new ResponseEntity<>(savedEnrollment, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EnrollmentDto> getEnrollmentById(@PathVariable("id") Integer enrollmentId) {
        EnrollmentDto enrollmentDto = enrollmentService.getEnrollmentById(enrollmentId);
        return ResponseEntity.ok(enrollmentDto);
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentDto>> getAllEnrollments() {
        List<EnrollmentDto> enrollments = enrollmentService.getAllEnrollments();
        return ResponseEntity.ok(enrollments);
    }

    @PutMapping("{id}")
    public ResponseEntity<EnrollmentDto> updateEnrollment(@PathVariable("id") Integer enrollmentId,
                                                          @RequestBody EnrollmentDto updatedEnrollment) {
        EnrollmentDto enrollmentDto = enrollmentService.updateEnrollment(enrollmentId, updatedEnrollment);
        return ResponseEntity.ok(enrollmentDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable("id") Integer enrollmentId) {
        enrollmentService.deleteEnrollment(enrollmentId);
        return ResponseEntity.ok("Enrollment deleted successfully!");
    }

}
