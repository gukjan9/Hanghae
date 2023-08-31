package com.test.spring1.controller;

import com.test.spring1.dto.UserResponseDto;
import com.test.spring1.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public UserResponseDto getUserInfo(@PathVariable Long id) {
        return userService.findUser(id);
    }

    @GetMapping("/user")
    public List<UserResponseDto> getUserList() {
        return userService.findAllUser();
    }

}