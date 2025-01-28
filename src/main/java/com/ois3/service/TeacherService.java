package com.ois3.service;

import com.ois3.dto.TeacherDto;

import java.util.List;

public interface TeacherService {

    TeacherDto createTeacher(TeacherDto dto);

    TeacherDto updateTeacher(Integer id, TeacherDto dto);

    TeacherDto getTeacherById(Integer id);

    List<TeacherDto> getAllTeachers();

    void deleteTeacher(Integer id);
}
