package com.ois3.controller;

import com.ois3.dto.AccountRoleDto;
import com.ois3.service.AccountRoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/account-role")
public class AccountRoleController {

    private final AccountRoleService accountRoleService;

    @PostMapping
    public ResponseEntity<AccountRoleDto> createAccountRole(@RequestBody AccountRoleDto accountRoleDto) {
        AccountRoleDto savedAccountRole = accountRoleService.createAccountRole(accountRoleDto);
        return new ResponseEntity<>(savedAccountRole, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AccountRoleDto> getAccountRoleById(@PathVariable("id") Integer accountRoleId) {
        AccountRoleDto accountRoleDto = accountRoleService.getAccountRoleById(accountRoleId);
        return ResponseEntity.ok(accountRoleDto);
    }

    @GetMapping
    public ResponseEntity<List<AccountRoleDto>> getAllAccountRoles() {
        List<AccountRoleDto> accountRoles = accountRoleService.getAllAccountRoles();
        return ResponseEntity.ok(accountRoles);
    }

    @PutMapping("{id}")
    public ResponseEntity<AccountRoleDto> updateAccountRole(@PathVariable("id") Integer accountRoleId,
                                                            @RequestBody AccountRoleDto updatedAccountRole) {
        AccountRoleDto accountRoleDto = accountRoleService.updateAccountRole(accountRoleId, updatedAccountRole);
        return ResponseEntity.ok(accountRoleDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAccountRole(@PathVariable("id") Integer accountRoleId) {
        accountRoleService.deleteAccountRole(accountRoleId);
        return ResponseEntity.ok("AccountRole deleted successfully!");
    }
}
