package com.example.javaweb.service;

import com.example.javaweb.model.User;
import com.example.javaweb.repository.BoardRepository;
import com.example.javaweb.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class UserService {

    final private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User insert(HashMap<String, Object> map) {
        User user = new User(map);
        return userRepository.save(user);
    }

    public User find(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public boolean delete(long id) {
        if (!userRepository.existsById(id)) {
            return false;
        }

        userRepository.deleteById(id);
        return true;
    }

    public User update(long id, HashMap<String, Object> map) {
        final User updateUser = new User(map);
        final Optional<User> savedUser = userRepository.findById(id);
        if (savedUser.isEmpty()) {
            return null;
        }

        savedUser.get().setName(updateUser.getName());

        return userRepository.save(savedUser.get());
    }
}
