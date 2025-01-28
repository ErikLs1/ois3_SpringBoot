package com.ois3.service;

import com.ois3.dto.SemesterDto;

import java.util.List;

public interface SemesterService {

    SemesterDto createSemester(SemesterDto dto);

    SemesterDto updateSemester(Integer id, SemesterDto dto);

    SemesterDto getSemesterById(Integer id);

    List<SemesterDto> getAllSemesters();

    void deleteSemester(Integer id);
}
