package com.example.javaweb.service;

import com.example.javaweb.model.User;
import com.example.javaweb.repository.BoardRepository;
import com.example.javaweb.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {

    final private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(HashMap<String, Object> map) {
        User user = new User(null, (String) map.get("name"));
        return userRepository.save(user);
    }
}
