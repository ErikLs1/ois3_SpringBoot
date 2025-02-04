package com.ois3.security.controller;

import com.ois3.entity.UserAccount;
import com.ois3.service.UserAccountService;
import com.ois3.service.impl.UserAccountServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserAccountService userAccountService;

    public UserController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserAccount> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserAccount currentUser = (UserAccount) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }
}
