package com.ois3.mapper;

import com.ois3.dto.AccountRoleDto;
import com.ois3.entity.AccountRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountRoleMapper {
    AccountRoleMapper INSTANCE = Mappers.getMapper(AccountRoleMapper.class);

    AccountRoleDto toDto(AccountRole entity);
    AccountRole toEntity(AccountRoleDto dto);
}
