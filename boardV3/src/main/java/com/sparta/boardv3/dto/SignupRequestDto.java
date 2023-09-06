package com.sparta.boardv3.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {
    @NotBlank(message = "아이디를 입력해주세요.")
    @Pattern(regexp = "^[a-z0-9]{3,9}$",
            message = "최소 4자 이상, 10자 이하, 알파벳 소문자와 숫자만 이용해주세요.")
    private String username;
    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^[A-Za-z0-9]{7,14}$",
            message = "최소 8자 이상, 15자 이하, 알파벳 대소문자와 숫자만 이용해주세요.")
    private String password;
    private boolean admin = false;
    private String adminToken = "";
}