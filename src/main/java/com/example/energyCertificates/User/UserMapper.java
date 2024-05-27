package com.example.energyCertificates.User;

import com.example.energyCertificates.User.Dtoes.UserDto;

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
