package com.sparta.boardv5.entity;

import com.sparta.boardv5.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "like")
@Entity
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "like")
    private boolean like;

    @ManyToOne
    @Column(name = "user_id")
    private User user;

    @ManyToOne
    @Column(name = "board_id")
    private Board board;

    @ManyToOne
    @Column(name = "comment_id")
    private Comment comment;

    public Like(boolean like, User user, Board board, Comment comment) {
        this.like = like;
        this.user = user;
        this.board = board;
        this.comment = comment;
    }
}
