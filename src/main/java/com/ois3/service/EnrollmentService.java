package com.ois3.service;

import com.ois3.dto.EnrollmentDto;

import java.util.List;

public interface EnrollmentService {

    EnrollmentDto createEnrollment(EnrollmentDto dto);

    EnrollmentDto updateEnrollment(Integer id, EnrollmentDto dto);

    EnrollmentDto getEnrollmentById(Integer id);

    List<EnrollmentDto> getAllEnrollments();

    void deleteEnrollment(Integer id);
}
