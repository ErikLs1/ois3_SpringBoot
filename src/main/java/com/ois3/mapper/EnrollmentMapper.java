package com.ois3.mapper;
import com.ois3.dto.EnrollmentDto;
import com.ois3.entity.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    EnrollmentMapper INSTANCE = Mappers.getMapper(EnrollmentMapper.class);

    @Mapping(target = "studentId", source = "student.studentId")
    @Mapping(target = "semesterSubjectId", source = "semesterSubject.semesterSubjectId")
    EnrollmentDto toDto(Enrollment entity);

    @Mapping(target = "student", ignore = true)
    @Mapping(target = "semesterSubject", ignore = true)
    Enrollment toEntity(EnrollmentDto dto);
}
