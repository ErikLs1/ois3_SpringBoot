package com.ois3.service.impl;

import com.ois3.dto.SemesterDto;
import com.ois3.entity.Semester;
import com.ois3.mapper.SemesterMapper;
import com.ois3.repository.SemesterRepository;
import com.ois3.service.SemesterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SemesterServiceImpl implements SemesterService {

    private final SemesterRepository semesterRepository;
    private final SemesterMapper semesterMapper;

    @Override
    public SemesterDto createSemester(SemesterDto dto) {
        Semester semester = semesterMapper.toEntity(dto);
        Semester saved = semesterRepository.save(semester);
        return semesterMapper.toDto(saved);
    }

    @Override
    public SemesterDto updateSemester(Integer id, SemesterDto dto) {
        Semester existing = semesterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Semester not found with id: " + id));

        existing.setSemesterName(dto.getSemesterName());
        existing.setSemesterYear(dto.getSemesterYear());

        Semester updated = semesterRepository.save(existing);
        return semesterMapper.toDto(updated);
    }

    @Override
    public SemesterDto getSemesterById(Integer id) {
        Semester semester = semesterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Semester not found with id: " + id));

        return semesterMapper.toDto(semester);
    }

    @Override
    public List<SemesterDto> getAllSemesters() {
        return semesterRepository.findAll().stream()
                .map(semesterMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSemester(Integer id) {
        Semester semester = semesterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Semester not found with id: " + id));
        semesterRepository.deleteById(id);
    }
}
