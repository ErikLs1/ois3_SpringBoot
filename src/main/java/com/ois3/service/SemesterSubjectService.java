package com.ois3.service;

import com.ois3.dto.SemesterSubjectDto;

import java.util.List;

public interface SemesterSubjectService {

    SemesterSubjectDto createSemesterSubject(SemesterSubjectDto dto);
    SemesterSubjectDto updateSemesterSubject(Integer id, SemesterSubjectDto dto);
    SemesterSubjectDto getSemesterSubjectById(Integer id);
    List<SemesterSubjectDto> getAllSemesterSubjects();
    void deleteSemesterSubject(Integer id);
}
