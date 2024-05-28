package com.example.energyCertificates.User.Service;

import com.example.energyCertificates.User.Dtoes.UserCredentialsDto;
import com.example.energyCertificates.User.Dtoes.UserDto;
import com.example.energyCertificates.User.Mappers.UserCredentialsMapper;
import com.example.energyCertificates.User.Mappers.UserMapper;
import com.example.energyCertificates.User.User;
import com.example.energyCertificates.User.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getUserDtoByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        return UserMapper.map(user);
    }

    public Optional<UserCredentialsDto> getUserCredentials(String email) {
        return Optional.of(userRepository.findUserByEmail(email))
                .map(UserCredentialsMapper::map);
    }
}
