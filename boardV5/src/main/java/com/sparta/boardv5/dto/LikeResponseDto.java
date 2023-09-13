package com.sparta.boardv5.dto;

import com.sparta.boardv5.entity.Board;
import com.sparta.boardv5.entity.Like;
import com.sparta.boardv5.entity.User;
import lombok.Getter;

@Getter
public class LikeResponseDto {
    private Long id;
    private boolean like;
    private Long userId;
    private Long boardId;
    private Long commentId;

    public LikeResponseDto(Like like, Board board, User user) {
        this.id = like.getId();
        this.like = like.getLike();
        this.userId = like.getUser().getId();
        this.boardId = board.getId();
    }
}
