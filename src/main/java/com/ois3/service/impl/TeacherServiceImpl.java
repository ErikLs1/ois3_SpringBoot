package com.ois3.service.impl;

import com.ois3.dto.TeacherDto;
import com.ois3.entity.Person;
import com.ois3.entity.Teacher;
import com.ois3.mapper.TeacherMapper;
import com.ois3.repository.PersonRepository;
import com.ois3.repository.TeacherRepository;
import com.ois3.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final PersonRepository personRepository;

    private TeacherDto getTeacherDto(TeacherDto dto, Teacher teacher) {
        if (dto.getPersonId() != null) {
            Person person = personRepository.findById(dto.getPersonId())
                    .orElseThrow(() -> new RuntimeException("Person not found with id: " + dto.getPersonId()));
            teacher.setPerson(person);
        }
        Teacher updated = teacherRepository.save(teacher);
        return teacherMapper.toDto(updated);
    }

    @Override
    public TeacherDto createTeacher(TeacherDto dto) {
        Teacher teacher = teacherMapper.toEntity(dto);

        return getTeacherDto(dto, teacher);
    }

    @Override
    public TeacherDto updateTeacher(Integer id, TeacherDto dto) {
        Teacher existing = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));

        existing.setDepartment(dto.getDepartment());
        existing.setHireDate(dto.getHireDate());

        return getTeacherDto(dto, existing);
    }

    @Override
    public TeacherDto getTeacherById(Integer id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        return teacherMapper.toDto(teacher);
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        return teacherRepository.findAll().stream()
                .map(teacherMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        teacherRepository.delete(teacher);
    }
}
