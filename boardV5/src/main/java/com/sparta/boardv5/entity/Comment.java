package com.sparta.boardv5.entity;

import com.sparta.boardv5.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "comment")
@Entity
public class Comment extends Timestamped {
    // N : 1 - Board : User
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "comment", nullable = false, length = 500)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    public Comment(CommentRequestDto requestDto, User user, Board board) {
        this.comment = requestDto.getComment();
        this.user = user;
        this.board = board;
    }

    public void update(CommentRequestDto requestDto) {
        this.comment = requestDto.getComment();
    }
}