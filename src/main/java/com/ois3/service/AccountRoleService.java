package com.ois3.service;

import com.ois3.dto.AccountRoleDto;

import java.util.List;

public interface AccountRoleService {

    AccountRoleDto createAccountRole(AccountRoleDto dto);

    AccountRoleDto updateAccountRole(Integer id, AccountRoleDto dto);

    AccountRoleDto getAccountRoleById(Integer id);

    List<AccountRoleDto> getAllAccountRoles();

    void deleteAccountRole(Integer id);
}
