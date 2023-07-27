package com.example.link3.service;

import com.example.link3.entity.User;
import com.example.link3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public void register(User user) throws Exception {
        Optional<User> op = userRepository.findByUsername(user.getUsername());

        if (op.isPresent()) {
            throw new Exception(("username already taken"));
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) throws Exception {
        Optional<User> op = userRepository.findByUsername(username);

        if (op.isEmpty()) {
            throw new Exception(("user not found"));
        }

        return op.get();
    }
}
