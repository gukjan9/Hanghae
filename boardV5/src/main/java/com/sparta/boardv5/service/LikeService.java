package com.sparta.boardv5.service;

import com.sparta.boardv5.dto.CommentRequestDto;
import com.sparta.boardv5.dto.CommentResponseDto;
import com.sparta.boardv5.entity.Board;
import com.sparta.boardv5.entity.Comment;
import com.sparta.boardv5.entity.User;
import com.sparta.boardv5.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final BoardRepository boardRepository;

    public LikeResponseDto likeBoard(Long id, CommentRequestDto requestDto, User user) {
        Board board = boardRepository.findBoardById(id).orElseThrow(() ->
                new NullPointerException("해당 글을 찾을 수 없습니다.")
        );
        Comment comment = commentRepository.save(new Comment(requestDto, user, board));
        return new LikeResponseDto(comment);
    }
}
