package com.ois3.service.impl;

import com.ois3.dto.StudentDto;
import com.ois3.entity.Person;
import com.ois3.entity.Student;
import com.ois3.mapper.StudentMapper;
import com.ois3.repository.PersonRepository;
import com.ois3.repository.StudentRepository;
import com.ois3.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final PersonRepository personRepository;

    //Check if person linked to student exists
    private StudentDto getStudentDto(StudentDto dto, Student student) {
        if (dto.getPersonId() != null) {
            Person person = personRepository.findById(dto.getPersonId())
                    .orElseThrow(() -> new RuntimeException("Person not found with id: " + dto.getPersonId()));
            student.setPerson(person);
        }

        Student updated = studentRepository.save(student);
        return studentMapper.toDto(updated);
    }

    @Override
    public StudentDto createStudent(StudentDto dto) {
        Student student = studentMapper.toEntity(dto);
        return getStudentDto(dto, student);
    }

    @Override
    public StudentDto updateStudent(Integer id, StudentDto dto) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        existing.setProgram(dto.getProgram());
        existing.setStartYear(dto.getStartYear());

        return getStudentDto(dto, existing);
    }

    @Override
    public StudentDto getStudentById(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return studentMapper.toDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteStudent(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        studentRepository.deleteById(id);
    }
}
