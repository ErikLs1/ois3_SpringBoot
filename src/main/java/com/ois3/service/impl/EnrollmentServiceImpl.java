package com.ois3.service.impl;

import com.ois3.dto.EnrollmentDto;
import com.ois3.entity.Enrollment;
import com.ois3.entity.SemesterSubject;
import com.ois3.entity.Student;
import com.ois3.mapper.EnrollmentMapper;
import com.ois3.repository.EnrollmentRepository;
import com.ois3.repository.SemesterSubjectRepository;
import com.ois3.repository.StudentRepository;
import com.ois3.service.EnrollmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;
    private final StudentRepository studentRepository;
    private final SemesterSubjectRepository semesterSubjectRepository;


    private EnrollmentDto getEnrollmentDto(EnrollmentDto dto, Enrollment enrollment) {
        if (dto.getStudentId() != null) {
            Student student = studentRepository.findById(dto.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found with id: " + dto.getStudentId()));
            enrollment.setStudent(student);
        }

        if (dto.getSemesterSubjectId() != null) {
            SemesterSubject semesterSubject = semesterSubjectRepository.findById(dto.getSemesterSubjectId())
                    .orElseThrow(() -> new RuntimeException("SemesterSubject not found with id: " + dto.getSemesterSubjectId()));
            enrollment.setSemesterSubject(semesterSubject);
        }

        Enrollment updated = enrollmentRepository.save(enrollment);
        return enrollmentMapper.toDto(updated);
    }

    @Override
    public EnrollmentDto createEnrollment(EnrollmentDto dto) {
        Enrollment enrollment = enrollmentMapper.toEntity(dto);

        return getEnrollmentDto(dto, enrollment);
    }

    @Override
    public EnrollmentDto updateEnrollment(Integer id, EnrollmentDto dto) {
        Enrollment existing = enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));

        existing.setFinalGrade(dto.getFinalGrade());
        existing.setStatus(dto.getStatus());
        existing.setEnrollmentDate(dto.getEnrollmentDate());

        return getEnrollmentDto(dto, existing);
    }

    @Override
    public EnrollmentDto getEnrollmentById(Integer id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));
        return enrollmentMapper.toDto(enrollment);
    }

    @Override
    public List<EnrollmentDto> getAllEnrollments() {
        return enrollmentRepository.findAll().stream()
                .map(enrollmentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEnrollment(Integer id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));
        enrollmentRepository.deleteById(id);
    }
}
