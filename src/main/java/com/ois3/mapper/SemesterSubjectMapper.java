package com.ois3.mapper;
import com.ois3.dto.SemesterSubjectDto;
import com.ois3.entity.SemesterSubject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SemesterSubjectMapper {
    SemesterSubjectMapper INSTANCE = Mappers.getMapper(SemesterSubjectMapper.class);

    @Mapping(target = "semesterId", source = "semester.semesterId")
    @Mapping(target = "subjectId", source = "subject.subjectId")
    @Mapping(target = "teacherId", source = "teacher.teacherId")
    SemesterSubjectDto toDto(SemesterSubject entity);

    @Mapping(target = "semester", ignore = true)
    @Mapping(target = "subject", ignore = true)
    @Mapping(target = "teacher", ignore = true)
    SemesterSubject toEntity(SemesterSubjectDto dto);
}
