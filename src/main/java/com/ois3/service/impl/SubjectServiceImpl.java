package com.ois3.service.impl;

import com.ois3.dto.SubjectDto;
import com.ois3.entity.Subject;
import com.ois3.mapper.SubjectMapper;
import com.ois3.repository.SubjectRepository;
import com.ois3.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    @Override
    public SubjectDto createSubject(SubjectDto dto) {
        Subject subject = subjectMapper.toEntity(dto);
        Subject saved = subjectRepository.save(subject);
        return subjectMapper.toDto(saved);
    }

    @Override
    public SubjectDto updateSubject(Integer id, SubjectDto dto) {
        Subject existing = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found with id: " + id));

        existing.setSubjectName(dto.getSubjectName());
        existing.setSubjectCode(dto.getSubjectCode());
        existing.setEAP(dto.getEAP());
        existing.setSubjectDescription(dto.getSubjectDescription());

        Subject updated = subjectRepository.save(existing);
        return subjectMapper.toDto(updated);
    }

    @Override
    public SubjectDto getSubjectById(Integer id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found with id: " + id));

        return subjectMapper.toDto(subject);
    }

    @Override
    public List<SubjectDto> getAllSubjects() {
        return subjectRepository.findAll().stream()
                .map(subjectMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSubject(Integer id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found with id: " + id));
        subjectRepository.deleteById(id);
    }
}
