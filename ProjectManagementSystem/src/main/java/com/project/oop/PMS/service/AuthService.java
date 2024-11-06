package com.project.oop.PMS.service;

import com.project.oop.PMS.entity.User;
import com.project.oop.PMS.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User login(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);

        // Trong thực tế nên mã hóa và so sánh mật khẩu
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        }
        return null;
    }

    public User register(String username, String password) {
        // Kiểm tra nếu tên người dùng đã tồn tại
        if (userRepository.findByUsername(username).isPresent()) {
            return null; // Hoặc ném ra một ngoại lệ nếu muốn
        }

        // Tạo người dùng mới và lưu vào cơ sở dữ liệu
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password); // Nên mã hóa mật khẩu ở đây
        return userRepository.save(newUser);
    }
}
