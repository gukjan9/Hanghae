package com.example.spring3.dto;

import lombok.Getter;

@Getter
public class ItemRequestDto {
    private String title;
    private String content;
    private int price;
    private String username;
}