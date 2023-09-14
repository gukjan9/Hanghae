package com.example.spring3.dto;

import lombok.Getter;

@Getter
public class StatusDto {
    String msg;

    public StatusDto(String msg) {
        this.msg = msg;
    }
}