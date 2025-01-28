package com.ois3.service.impl;

import com.ois3.dto.UserAccountDto;
import com.ois3.entity.AccountRole;
import com.ois3.entity.Person;
import com.ois3.entity.UserAccount;
import com.ois3.mapper.UserAccountMapper;
import com.ois3.repository.AccountRoleRepository;
import com.ois3.repository.PersonRepository;
import com.ois3.repository.UserAccountRepository;
import com.ois3.service.UserAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private final UserAccountMapper userAccountMapper;
    private final PersonRepository personRepository;
    private final AccountRoleRepository accountRoleRepository;

    private UserAccountDto getUserAccountDto(UserAccountDto dto, UserAccount userAccount) {
        if (dto.getPersonId() != null) {
            Person person = personRepository.findById(dto.getPersonId())
                    .orElseThrow(() -> new RuntimeException("Person not found with id: " + dto.getPersonId()));
            userAccount.setPerson(person);
        }

        if (dto.getAccountRoleId() != null) {
            AccountRole accountRole = accountRoleRepository.findById(dto.getAccountRoleId())
                    .orElseThrow(() -> new RuntimeException("AccountRole not found with id: " + dto.getAccountRoleId()));
            userAccount.setAccountRole(accountRole);
        }

        UserAccount updated = userAccountRepository.save(userAccount);
        return userAccountMapper.toDto(updated);
    }


    @Override
    public UserAccountDto createUserAccount(UserAccountDto dto) {
        UserAccount userAccount = userAccountMapper.toEntity(dto);

        return getUserAccountDto(dto, userAccount);
    }

    @Override
    public UserAccountDto updateUserAccount(Integer id, UserAccountDto dto) {
        UserAccount existing = userAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserAccount not found with id: " + id));

        existing.setUsername(dto.getUsername());
        if (dto.getPassword() != null) {
            existing.setPassword(dto.getPassword());
        }

        return getUserAccountDto(dto, existing);
    }

    @Override
    public UserAccountDto getUserAccountById(Integer id) {
        UserAccount userAccount = userAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserAccount not found with id: " + id));
        return userAccountMapper.toDto(userAccount);
    }

    @Override
    public List<UserAccountDto> getUserAccounts() {
        return userAccountRepository.findAll().stream()
                .map(userAccountMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUserAccount(Integer id) {
        UserAccount userAccount = userAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserAccount not found with id: " + id));
        userAccountRepository.deleteById(id);
    }
}
