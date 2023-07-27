package com.example.link3.service;

import com.example.link3.dto.AuthDto;
import com.example.link3.dto.AuthResponseDto;
import com.example.link3.dto.UserDto;
import com.example.link3.entity.User;
import com.example.link3.repository.UserRepository;
import com.example.link3.security.CustomUserDetail;
import com.example.link3.security.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(JwtUtils jwtUtils, AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto register(AuthDto auth) throws Exception {
        Optional<User> op = userRepository.findByUsername(auth.getUsername());

        if (op.isPresent()) {
            throw new Exception(("username already taken"));
        }

        User user = new User();
        user.setUsername(auth.getUsername());
        user.setPassword(passwordEncoder.encode(auth.getPassword()));
        return toDto(userRepository.save(user));
    }

    @Override
    public AuthResponseDto login(AuthDto auth) throws Exception {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword()));
        if (authentication.isAuthenticated()) {
            CustomUserDetail userDetail = (CustomUserDetail) authentication.getPrincipal();
            UserDto dto=new UserDto(userDetail.getId(), userDetail.getUsername());
            return new AuthResponseDto(dto, jwtUtils.generateToken(dto.getUsername()));
        } else {
            throw new UsernameNotFoundException("invalid authentication");
        }

    }

    @Override
    public UserDto findByUsername(String username) throws Exception {
        Optional<User> op = userRepository.findByUsername(username);

        if (op.isEmpty()) {
            throw new Exception(("user not found"));
        }

        return toDto(op.get());
    }

    @Override
    public UserDto toDto(User entity) {
        return new UserDto(entity.getId(), entity.getUsername());
    }

    @Override
    public User toEntity(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        return user;
    }
}
