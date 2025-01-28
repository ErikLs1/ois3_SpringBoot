package com.ois3.service;

import com.ois3.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto dto);

    StudentDto updateStudent(Integer id, StudentDto dto);

    StudentDto getStudentById(Integer id);

    List<StudentDto> getAllStudents();

    void deleteStudent(Integer id);
}
