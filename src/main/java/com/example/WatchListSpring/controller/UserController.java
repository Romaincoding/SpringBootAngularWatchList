package com.example.WatchListSpring.controller;

import com.example.WatchListSpring.entity.User;
import com.example.WatchListSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    // standard constructors

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user){
    userRepository.save(user);
    }


    @DeleteMapping("/users/{id}")
     boolean deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return true;

    }



}