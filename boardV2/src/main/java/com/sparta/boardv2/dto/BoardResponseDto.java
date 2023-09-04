package com.sparta.boardv2.dto;

import com.sparta.boardv2.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;

// 반환해주는거
@Getter
public class BoardResponseDto {
    private Long id;
    private String username;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.username = board.getUsername();
        this.contents = board.getContents();
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
    }
}