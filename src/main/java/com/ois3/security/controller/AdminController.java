package com.ois3.security.controller;

import com.ois3.entity.UserAccount;
import com.ois3.repository.UserAccountRepository;
import com.ois3.security.dto.RoleAssignmentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final UserAccountRepository userAccountRepository;

    public AdminController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/assign-role")
    public ResponseEntity<UserAccount> assignRole(@RequestBody RoleAssignmentDto dto) {
        UserAccount user = userAccountRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        user.getRoles().add(dto.getRole());
        UserAccount updatedUser = userAccountRepository.save(user);

        return ResponseEntity.ok(updatedUser);
    }
}
