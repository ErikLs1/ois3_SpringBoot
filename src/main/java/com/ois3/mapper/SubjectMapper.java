package com.ois3.mapper;

import com.ois3.dto.SubjectDto;
import com.ois3.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);

    SubjectDto toDto(Subject entity);
    Subject toEntity(SubjectDto dto);
}
