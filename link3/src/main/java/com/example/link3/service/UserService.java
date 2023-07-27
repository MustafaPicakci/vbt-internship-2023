package com.example.link3.service;

import com.example.link3.entity.User;

public interface UserService {

    void register(User user) throws Exception;

    User findByUsername(String username) throws Exception;
}
