package com.ois3.mapper;

import com.ois3.dto.StudentDto;
import com.ois3.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(target = "personId", source = "person.personId")
    StudentDto toDto(Student entity);

    @Mapping(target = "person", ignore = true)
    Student toEntity(StudentDto dto);
}
