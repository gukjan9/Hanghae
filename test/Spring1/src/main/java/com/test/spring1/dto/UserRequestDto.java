package com.test.spring1.dto;

import lombok.Getter;

@Getter
public class UserRequestDto {
    private Long id;
    private String name;
    private String email;
    private String pw;
}

