package com.example.demo.service.Impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUserame(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public String deleteById(String id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            return null;
        }
        userRepository.deleteById(id);
        return id;
    }

    @Override
    public User update(String id, User user) {
        Optional<User> userUpdate = userRepository.findById(id);
        if (!userUpdate.isPresent()) {
            return null;
        }
        else {
            User u = userUpdate.get();
            u.setUsername(user.getUsername());
            u.setPassword(user.getPassword());
            u.setEmail(user.getEmail());
            return userRepository.save(u);
        }
    }
}
