package com.ois3.controller;

import com.ois3.dto.UserAccountDto;
import com.ois3.service.UserAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/user-account")
public class UserAccountController {

    private final UserAccountService userAccountService;

    @PostMapping
    public ResponseEntity<UserAccountDto> createUserAccount(@RequestBody UserAccountDto userAccountDto) {
        UserAccountDto savedUserAccount = userAccountService.createUserAccount(userAccountDto);
        return new ResponseEntity<>(savedUserAccount, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserAccountDto> getUserAccountById(@PathVariable("id") Integer userAccountId) {
        UserAccountDto userAccountDto = userAccountService.getUserAccountById(userAccountId);
        return ResponseEntity.ok(userAccountDto);
    }

    @GetMapping
    public ResponseEntity<List<UserAccountDto>> getAllUserAccounts() {
        List<UserAccountDto> userAccounts = userAccountService.getUserAccounts();
        return ResponseEntity.ok(userAccounts);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserAccountDto> updateUserAccount(@PathVariable("id") Integer userAccountId,
                                                            @RequestBody UserAccountDto updatedUserAccount) {
        UserAccountDto userAccountDto = userAccountService.updateUserAccount(userAccountId, updatedUserAccount);
        return ResponseEntity.ok(userAccountDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserAccount(@PathVariable("id") Integer userAccountId) {
        userAccountService.deleteUserAccount(userAccountId);
        return ResponseEntity.ok("UserAccount deleted successfully!");
    }
}
