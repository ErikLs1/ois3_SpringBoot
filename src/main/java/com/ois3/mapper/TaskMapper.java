package com.ois3.mapper;

import com.ois3.dto.TaskDto;
import com.ois3.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDto toDto(Task entity);
    Task toEntity(TaskDto dto);
}
