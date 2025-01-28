package com.ois3.service;

import com.ois3.dto.SubjectDto;

import java.util.List;

public interface SubjectService {

    SubjectDto createSubject(SubjectDto dto);

    SubjectDto updateSubject(Integer id, SubjectDto dto);

    SubjectDto getSubjectById(Integer id);

    List<SubjectDto> getAllSubjects();

    void deleteSubject(Integer id);
}
