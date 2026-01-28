package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final Map<String, User> memory = new HashMap<>();

    public User save(User user) {
        memory.put(user.getIpAddress(), user);
        return user;
    }

    public User findByIp(String ip) {
        return memory.get(ip);
    }

    public void deleteByIp(User user) {
        memory.remove(user.getIpAddress());

    }
}
