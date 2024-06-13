package com.example.energyCertificates.User.Service;

import com.example.energyCertificates.User.Dtoes.UserCredentialsDto;
import com.example.energyCertificates.User.Mappers.UserCredentialsMapper;
import com.example.energyCertificates.User.User;
import com.example.energyCertificates.User.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<UserCredentialsDto> getUserCredentials(String email) {
        return Optional.of(userRepository.getUserByEmail(email))
                .map(UserCredentialsMapper::map);
    }

    @Transactional
    public void changePassword(String newPassword) {
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.getUserByEmail(currentUserEmail);
        String passwordHash = passwordEncoder.encode(newPassword);

        user.setPassword(passwordHash);
    }
}
