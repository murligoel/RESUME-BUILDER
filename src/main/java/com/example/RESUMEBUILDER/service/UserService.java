package com.example.RESUMEBUILDER.service;

import com.example.RESUMEBUILDER.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    List<User> getAllUsers();
}
