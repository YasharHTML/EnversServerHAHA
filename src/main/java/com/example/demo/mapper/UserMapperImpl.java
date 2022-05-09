package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;

public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        if (user == null) {
            return null;
        }
        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.id(user.getId());
        userDto.dob(user.getDob());
        userDto.email(user.getEmail());
        userDto.name(user.getName());

        return userDto.build();
    }
}
