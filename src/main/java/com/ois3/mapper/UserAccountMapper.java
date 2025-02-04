package com.ois3.mapper;

import com.ois3.dto.UserAccountDto;
import com.ois3.entity.UserAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {
    UserAccountMapper INSTANCE = Mappers.getMapper(UserAccountMapper.class);

    @Mapping(target = "personId", source = "person.personId")
    UserAccountDto toDto(UserAccount entity);

    @Mapping(target = "person", ignore = true)
    UserAccount toEntity(UserAccountDto dto);
}
