package com.ois3.security.service;

import com.ois3.entity.UserAccount;
import com.ois3.repository.UserAccountRepository;
import com.ois3.security.dto.LoginUserDto;
import com.ois3.security.dto.RegisterUserDto;
import com.ois3.security.dto.VerifyUserDto;
import com.ois3.security.model.Role;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class AuthenticationService {
    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    private AuthenticationService(UserAccountRepository userAccountRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public UserAccount signup(RegisterUserDto input) {
        UserAccount user = new UserAccount(input.getUsername(), input.getEmail(), passwordEncoder.encode(input.getPassword()));
        user.getRoles().add(Role.STUDENT);
        user.setVerificationCode(generateVerificationCode());
        user.setVerificationExpiresAt(LocalDateTime.now().plusMinutes(15));
        user.setEnabled(false);
        System.out.println(user.getVerificationCode());
        return userAccountRepository.save(user);
    }

    public UserAccount authenticate(LoginUserDto input) {
        UserAccount user = userAccountRepository.findByEmail(input.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getEnabled()) {
            throw new RuntimeException("Account not yet verified. Please verify your account");
        }
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return user;
    }

    public void verifyUser(VerifyUserDto input) {
        Optional<UserAccount> optionalUser = userAccountRepository.findByEmail(input.getEmail());

        if (optionalUser.isPresent()) {
            UserAccount user = optionalUser.get();

            if (user.getVerificationExpiresAt().isBefore(LocalDateTime.now())) {
                throw new RuntimeException("Verification code has expired!");
            }

            if (user.getVerificationCode().equals(input.getVerificationCode())) {
                user.setEnabled(true);
                user.setVerificationCode(null);
                user.setVerificationExpiresAt(null);
                userAccountRepository.save(user);
            } else {
                throw new RuntimeException("Invalid verification code!");
            }
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public void resendVerificationCode(String email) {
        Optional<UserAccount> optionalUser = userAccountRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            UserAccount user = optionalUser.get();
            if (user.isEnabled()) {
                throw new RuntimeException("Account is already verified.");
            }
            user.setVerificationCode(generateVerificationCode());
            user.setVerificationExpiresAt(LocalDateTime.now().minusHours(1));
            // send code
            System.out.println(user.getVerificationCode());
            userAccountRepository.save(user);
        } else {
            throw new RuntimeException("User not found.");
        }
    }

    private String generateVerificationCode() {
        Random random = new Random();
        int code = random.nextInt(900000) + 100000;
        return String.valueOf(code);
    }
}
