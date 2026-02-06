package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> getUser(@RequestBody User user) {
        User checkUser = userService.findByIp(user.getIpAddress());

        if (checkUser != null) {
            // Käyttäjä löytyi → palautetaan user-objekti
            return ResponseEntity.ok(Map.of(
                    "status", "already_visited",
                    "user", checkUser));
        } else {
            // Käyttäjää ei löytynyt → tallennetaan ja palautetaan viesti
            userService.save(user);
            return ResponseEntity.ok(Map.of(
                    "status", "new_visitor",
                    "message", "User not found, saved new visitor",
                    "user", user));
        }
        // return ResponseEntity.ok(checkUser);
    }

    @PostMapping("/reset")
    public ResponseEntity<?> resetUser(@RequestBody User user) {
        userService.deleteByIp(user);
        return ResponseEntity.ok(Map.of("message", "User reset", "ip", user.getIpAddress()));
    }

}
