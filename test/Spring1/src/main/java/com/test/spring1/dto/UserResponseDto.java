package com.test.spring1.dto;

import com.test.spring1.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class UserResponseDto {
    private Long userId;
    private String name;
    private String email;
    private String pw;

    public UserResponseDto(User user) {
        this.userId = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.pw = user.getPw();
    }
}
