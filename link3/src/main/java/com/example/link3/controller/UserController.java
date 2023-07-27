package com.example.link3.controller;

import com.example.link3.dto.AuthDto;
import com.example.link3.dto.UserDto;
import com.example.link3.entity.User;
import com.example.link3.security.JwtUtils;
import com.example.link3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthDto auth) throws Exception {
        return ResponseEntity.ok(userService.login(auth));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody AuthDto auth) throws Exception {
        return ResponseEntity.ok(userService.register(auth));
    }
}
