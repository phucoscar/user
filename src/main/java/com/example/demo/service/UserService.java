package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> findAll();

    public User save(User user);

    public Optional<User> findById(String id);

    public Optional<User> findByUserame(String username);

    public String deleteById(String id);

    public User update(String id, User user);
}
