package com.example.link3.service;

import com.example.link3.dto.AuthDto;
import com.example.link3.dto.AuthResponseDto;
import com.example.link3.dto.UserDto;
import com.example.link3.entity.User;

public interface UserService {
    UserDto register(AuthDto auth) throws Exception;

    AuthResponseDto login(AuthDto auth) throws Exception;

    UserDto findByUsername(String username) throws Exception;

    UserDto toDto(User entity);

    User toEntity(UserDto entity);
}
