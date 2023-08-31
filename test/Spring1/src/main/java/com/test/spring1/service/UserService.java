package com.test.spring1.service;

import com.test.spring1.dto.UserResponseDto;
import com.test.spring1.entity.User;
import com.test.spring1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 질문
    public UserResponseDto findUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new NullPointerException("해당 User 는 존재하지 않습니다.")
        );
        return new UserResponseDto(user);
    }

    public List<UserResponseDto> findAllUser() {
        return userRepository.findAllByOrderById().stream().map(UserResponseDto::new).toList();
    }
}