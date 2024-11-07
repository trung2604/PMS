package com.project.oop.PMS.service;

import com.project.oop.PMS.entity.User;
import com.project.oop.PMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(String username, String password) {
        // Kiểm tra trùng lặp username
        if (userRepository.findByName(username).isPresent()) {
            throw new RuntimeException("Username đã tồn tại!");
        }

        // Tạo và lưu người dùng mới
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        return userRepository.save(user);
    }

    public Optional<User> loginUser(String username, String password) {
        Optional<User> user = userRepository.findByName(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        return Optional.empty();
    }
}
