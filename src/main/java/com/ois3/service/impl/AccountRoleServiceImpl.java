package com.ois3.service.impl;

import com.ois3.dto.AccountRoleDto;
import com.ois3.entity.AccountRole;
import com.ois3.mapper.AccountRoleMapper;
import com.ois3.repository.AccountRoleRepository;
import com.ois3.service.AccountRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountRoleServiceImpl implements AccountRoleService {

    private final AccountRoleRepository accountRoleRepository;
    private final AccountRoleMapper accountRoleMapper;

    @Override
    public AccountRoleDto createAccountRole(AccountRoleDto dto) {
        AccountRole accountRole = accountRoleMapper.toEntity(dto);
        AccountRole saved = accountRoleRepository.save(accountRole);
        return accountRoleMapper.toDto(saved);
    }

    @Override
    public AccountRoleDto updateAccountRole(Integer id, AccountRoleDto dto) {
        AccountRole existing = accountRoleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AccountRole not found with id: " + id));

        existing.setRoleName(dto.getRoleName());
        existing.setDescription(dto.getDescription());

        AccountRole updated = accountRoleRepository.save(existing);
        return accountRoleMapper.toDto(updated);
    }

    @Override
    public AccountRoleDto getAccountRoleById(Integer id) {
        AccountRole accountRole = accountRoleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AccountRole not found with id: " + id));
        return accountRoleMapper.toDto(accountRole);
    }

    @Override
    public List<AccountRoleDto> getAllAccountRoles() {
        return accountRoleRepository.findAll().stream()
                .map(accountRoleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccountRole(Integer id) {
        AccountRole accountRole = accountRoleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AccountRole not found with id: " + id));
        accountRoleRepository.deleteById(id);
    }
}
