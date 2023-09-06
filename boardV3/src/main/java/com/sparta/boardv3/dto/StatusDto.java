package com.sparta.boardv3.dto;

import lombok.Getter;

// Getter
// https://velog.io/@kai6666/Spring-%EC%8A%A4%ED%94%84%EB%A7%81-%EC%8A%AC%EB%9D%BC%EC%9D%B4%EC%8A%A4-%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%A4%91-406-org.springframework.web.HttpMediaTypeNotAcceptableException-Could-not-find-acceptable-representation-%EC%97%90%EB%9F%AC
@Getter
public class StatusDto {
    String msg;
    int statusCode;

    public StatusDto(String msg, int statusCode) {
        this.msg = msg;
        this.statusCode = statusCode; // 200, 400, 401, 500 등  HTTP 상태 코드
    }
}