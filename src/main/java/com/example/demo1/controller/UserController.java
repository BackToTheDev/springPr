package com.example.demo1.controller;

import com.example.demo1.entity.User;
import com.example.demo1.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

     final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }



    //id 조회
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not fond with id " + id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User newUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "User deleted with id " + id;
    }

    //이름으로 검색
    @GetMapping("/search")
    public List<User> getUser(@RequestParam String name) {
        return userRepository.findByName(name);
    }

    @GetMapping("/search/email")
    public List<User> searchByEmail(@RequestParam String keyword) {
        return userRepository.findByEmailContaining(keyword);
    }




}
