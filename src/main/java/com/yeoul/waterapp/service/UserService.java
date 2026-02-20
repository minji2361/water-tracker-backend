package com.yeoul.waterapp.service;

import com.yeoul.waterapp.domain.User;
import com.yeoul.waterapp.dto.UserCreateRequest;
import com.yeoul.waterapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserCreateRequest request) {
        User user = new User(
                request.getNickname(),
                request.getBirthDate(),
                request.getGender(),
                request.getWeight(),
                request.getHeight()
        );
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}