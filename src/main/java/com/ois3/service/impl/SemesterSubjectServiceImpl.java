package com.ois3.service.impl;

import com.ois3.dto.SemesterSubjectDto;
import com.ois3.entity.Semester;
import com.ois3.entity.SemesterSubject;
import com.ois3.entity.Subject;
import com.ois3.entity.Teacher;
import com.ois3.mapper.SemesterSubjectMapper;
import com.ois3.repository.SemesterRepository;
import com.ois3.repository.SemesterSubjectRepository;
import com.ois3.repository.SubjectRepository;
import com.ois3.repository.TeacherRepository;
import com.ois3.service.SemesterSubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SemesterSubjectServiceImpl implements SemesterSubjectService {

    private final SemesterSubjectRepository semesterSubjectRepository;
    private final SemesterSubjectMapper semesterSubjectMapper;
    private final SemesterRepository semesterRepository;
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;


    private SemesterSubjectDto getSemesterSubjectDto(SemesterSubjectDto dto, SemesterSubject semesterSubject) {
        if (dto.getSemesterId() != null) {
            Semester semester = semesterRepository.findById(dto.getSemesterId())
                    .orElseThrow(() -> new RuntimeException("Semester not found with id: " + dto.getSemesterId()));
            semesterSubject.setSemester(semester);
        }

        if (dto.getSubjectId() != null) {
            Subject subject = subjectRepository.findById(dto.getSubjectId())
                    .orElseThrow(() -> new RuntimeException("Subject not found with id: " + dto.getSubjectId()));
            semesterSubject.setSubject(subject);
        }

        if (dto.getTeacherId() != null) {
            Teacher teacher = teacherRepository.findById(dto.getTeacherId())
                    .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + dto.getTeacherId()));
            semesterSubject.setTeacher(teacher);
        }

        SemesterSubject updated = semesterSubjectRepository.save(semesterSubject);
        return semesterSubjectMapper.toDto(updated);
    }

    @Override
    public SemesterSubjectDto createSemesterSubject(SemesterSubjectDto dto) {
        SemesterSubject entity = semesterSubjectMapper.toEntity(dto);

        return getSemesterSubjectDto(dto, entity);
    }

    @Override
    public SemesterSubjectDto updateSemesterSubject(Integer id, SemesterSubjectDto dto) {
        SemesterSubject existing = semesterSubjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SemesterSubject not found with id: " + id));

        existing.setRoom(dto.getRoom());
        existing.setStartDate(dto.getStartDate());
        existing.setEndDate(dto.getEndDate());

        return getSemesterSubjectDto(dto, existing);
    }

    @Override
    public SemesterSubjectDto getSemesterSubjectById(Integer id) {
        SemesterSubject semesterSubject = semesterSubjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SemesterSubject not found with id: " + id));
        return semesterSubjectMapper.toDto(semesterSubject);
    }

    @Override
    public List<SemesterSubjectDto> getAllSemesterSubjects() {
        return semesterSubjectRepository.findAll().stream()
                .map(semesterSubjectMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSemesterSubject(Integer id) {
        SemesterSubject semesterSubject = semesterSubjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SemesterSubject not found with id: " + id));
        semesterSubjectRepository.delete(semesterSubject);
    }
}
