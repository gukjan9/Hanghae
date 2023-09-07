package com.example.jpa_relation_test.dto;

import lombok.Getter;

@Getter
public class MemberRequestDto {
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private String nickname;
}
