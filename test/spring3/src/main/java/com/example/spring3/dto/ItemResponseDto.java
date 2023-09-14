package com.example.spring3.dto;

import com.example.spring3.entity.Item;
import lombok.Getter;

// 반환해주는거
@Getter
public class ItemResponseDto {
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    public ItemResponseDto(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.content = item.getContent();
        this.price = item.getPrice();
        this.username = item.getUsername();
    }
}