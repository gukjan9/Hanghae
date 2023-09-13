package com.sparta.boardv5.dto;

import com.sparta.boardv5.entity.Board;
import com.sparta.boardv5.entity.Comment;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;

// 반환해주는거
@Getter
public class BoardResponseDto {
    private Long id;
    private String username;
    private String title;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @OneToMany(mappedBy = "comment")
    private String commentList = String.valueOf(new ArrayList<>());

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.username = board.getUser().getUsername();
        this.title = board.getTitle();
        this.contents = board.getContents();
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
    }

    public BoardResponseDto(Board board, Comment comment){
        this.id = board.getId();
        this.username = board.getUser().getUsername();
        this.title = board.getTitle();
        this.contents = board.getContents();
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
        this.commentList = comment.getComment();
    }
}