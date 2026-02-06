package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // private final Map<String, User> memory = new HashMap<>();

    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    public User findByIp(String ip) {
        return userRepository.findByIpAddress(ip);
    }

    public void deleteByIp(User user) {
        // pitää olla hallittu - jpa ettii id perusteella -> haetaan ensin käyttäjä
        // ip:llä, jos löytyy, niin sitten delete
        User findUser = userRepository.findByIpAddress(user.getIpAddress());
        if (findUser != null) {
            userRepository.delete(findUser);
        }
    }
}
