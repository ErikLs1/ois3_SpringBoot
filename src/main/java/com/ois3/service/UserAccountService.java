package com.ois3.service;

import com.ois3.dto.UserAccountDto;

import java.util.List;

public interface UserAccountService {

    UserAccountDto createUserAccount(UserAccountDto dto);

    UserAccountDto updateUserAccount(Integer id, UserAccountDto dto);

    UserAccountDto getUserAccountById(Integer id);

    List<UserAccountDto> getUserAccounts();

    void deleteUserAccount(Integer id);
}
