package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> getUser(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        User checkUser = userService.findByIp(ip);

        if (checkUser != null) {
            // Käyttäjä löytyi → palautetaan user-objekti
            return ResponseEntity.ok(Map.of(
                    "status", "already_visited",
                    "user", checkUser));
        } else {
            // Käyttäjää ei löytynyt → luo uusi obekti ja tallennetaan ja palautetaan viesti
            User user = new User();
            user.setIpAddress(ip);
            LocalDateTime now = LocalDateTime.now();
            // ZonedDateTime now = ZonedDateTime.now();
            user.setVisitTime(now);
            userService.save(user);
            return ResponseEntity.ok(Map.of(
                    "status", "new_visitor",
                    "message", "User not found, saved new visitor",
                    "user", user));
        }
        // return ResponseEntity.ok(checkUser);
    }

    @PutMapping("/user")
    public ResponseEntity<?> userChanges(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        User user = userService.findByIp(ip);

        if (user == null) {
            return ResponseEntity.ok(user);
        } else {
            user.setRickRolled(true);
            userService.save(user);
            return ResponseEntity.ok(user);
        }
    }

    @PostMapping("/reset")
    public ResponseEntity<?> resetUser(@RequestBody User user) {
        userService.deleteByIp(user);
        return ResponseEntity.ok(Map.of("message", "User reset", "ip", user.getIpAddress()));
    }

}
