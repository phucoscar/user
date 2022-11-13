package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> getAll() {
        return userService.findAll();
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id ,@RequestBody User user) {
        User userUpdate = userService.update(id, user);
        if (userUpdate != null)
            return new ResponseEntity<>(userUpdate, HttpStatus.OK);
        else
            return new ResponseEntity<>("Khong tim thay user", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        String idDelete = userService.deleteById(id);
        if (idDelete != null)
            return new ResponseEntity<>(id, HttpStatus.OK);
        else
            return new ResponseEntity<>("Khong tim thay user", HttpStatus.OK);
    }
}
