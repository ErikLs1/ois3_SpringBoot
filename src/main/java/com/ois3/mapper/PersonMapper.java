package com.ois3.mapper;

import com.ois3.dto.PersonDto;
import com.ois3.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDto toDto(Person entity);
    Person toEntity(PersonDto dto);
}
