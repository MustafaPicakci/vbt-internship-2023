package com.example.link3.controller;

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

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok(jwtUtils.generateToken(user.getUsername()));
        }
        {
            throw new UsernameNotFoundException("invalid authentication");
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user) throws Exception {
        userService.register(user);
        return ResponseEntity.ok().build();
    }


}
