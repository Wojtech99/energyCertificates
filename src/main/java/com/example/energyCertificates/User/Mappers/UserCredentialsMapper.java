package com.example.energyCertificates.User.Mappers;

import com.example.energyCertificates.User.Dtoes.UserCredentialsDto;
import com.example.energyCertificates.User.User;

public class UserCredentialsMapper {
    public static UserCredentialsDto map(User user) {
        return new UserCredentialsDto(
                user.getEmail(),
                user.getPassword()
        );
    }
}
