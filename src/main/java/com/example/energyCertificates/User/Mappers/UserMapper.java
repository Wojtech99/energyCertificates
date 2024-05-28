package com.example.energyCertificates.User.Mappers;

import com.example.energyCertificates.User.Dtoes.UserDto;
import com.example.energyCertificates.User.User;

public class UserMapper {
    public static User map(UserDto userDto) {
        User user = new User(
                userDto.getEmail(),
                userDto.getPassword()
        );

        user.setId(userDto.getId());

        return user;
    }

    public static UserDto map(User user) {
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getPassword()
        );
    }
}
