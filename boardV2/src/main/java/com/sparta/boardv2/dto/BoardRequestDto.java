package com.sparta.boardv2.dto;

import lombok.Getter;

@Getter
public class BoardRequestDto {
    private String username;
    private String title;
    private String contents;
    private String password;
}