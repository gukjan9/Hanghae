package com.sparta.boardv3.controller;

import com.sparta.boardv3.dto.SignupRequestDto;
import com.sparta.boardv3.dto.StatusDto;
import com.sparta.boardv3.entity.User;
import com.sparta.boardv3.jwt.JwtUtil;
import com.sparta.boardv3.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/user/signup")
    public StatusDto signup(@RequestBody @Valid SignupRequestDto requestDto, BindingResult bindingResult) {
        // Validation 예외처리
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if(fieldErrors.size() > 0) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                log.error(fieldError.getField() + " 필드 : " + fieldError.getDefaultMessage());
            }
        }
        userService.signup(requestDto);
        return new StatusDto("저장 성공", 200);
    }

    // https://velog.io/@jkijki12/Spirng-Security-Jwt-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0
//    @PostMapping("/user/login")
//    public String login(@RequestBody @Valid SignupRequestDto requestDto) {
//        String token = jwtUtil.createToken(requestDto.getUsername());
//        return jwtUtil.createToken(requestDto.getUsername());
//    }
}