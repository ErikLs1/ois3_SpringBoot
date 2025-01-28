package com.ois3.mapper;
import com.ois3.dto.SemesterDto;
import com.ois3.entity.Semester;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SemesterMapper {
    SemesterMapper INSTANCE = Mappers.getMapper(SemesterMapper.class);

    SemesterDto toDto(Semester entity);
    Semester toEntity(SemesterDto dto);
}
