package com.sparta.boardv3.dto;

import com.sparta.boardv3.entity.Board;
import com.sparta.boardv3.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

// 반환해주는거
@Getter
public class CommentResponseDto {
    private Long id;
    private Long userId;
    private String username;
    private Long boardId;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.userId = comment.getUser().getId();
        this.username = comment.getUser().getUsername();
        this.boardId = comment.getBoard().getId();
        this.comment = comment.getComment();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}