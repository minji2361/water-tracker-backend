package com.yeoul.waterapp.service;

import com.yeoul.waterapp.domain.User;
import com.yeoul.waterapp.dto.UserCreateRequest;
import com.yeoul.waterapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(UserCreateRequest request) {

        User user = User.builder()
                .nickname(request.getUser_name())
                .birthDate(request.getUser_birth())
                .gender(request.getUser_gen())
                .weight(request.getUser_wgt())
                .height(request.getUser_hgt())
                .build();

        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}