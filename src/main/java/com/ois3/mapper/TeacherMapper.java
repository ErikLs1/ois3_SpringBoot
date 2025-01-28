package com.ois3.mapper;

import com.ois3.dto.TeacherDto;
import com.ois3.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    @Mapping(target = "personId", source = "person.personId")
    TeacherDto toDto(Teacher entity);

    @Mapping(target = "person", ignore = true)
    Teacher toEntity(TeacherDto dto);
}
