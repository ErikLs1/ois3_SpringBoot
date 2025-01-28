package com.ois3.mapper;

import com.ois3.dto.TaskGradeDto;
import com.ois3.entity.TaskGrade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TaskGradeMapper {
    TaskGradeMapper INSTANCE = Mappers.getMapper(TaskGradeMapper.class);

    @Mapping(target = "taskId", source = "task.taskId")
    @Mapping(target = "enrollmentId", source = "enrollment.enrollmentId")
    @Mapping(target = "teacherId", source = "teacher.teacherId")
    TaskGradeDto toDto(TaskGrade entity);

    @Mapping(target = "task", ignore = true)
    @Mapping(target = "enrollment", ignore = true)
    @Mapping(target = "teacher", ignore = true)
    TaskGrade toEntity(TaskGradeDto dto);
}
