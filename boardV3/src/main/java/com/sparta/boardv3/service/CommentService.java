package com.sparta.boardv3.service;

import com.sparta.boardv3.dto.CommentRequestDto;
import com.sparta.boardv3.dto.StatusDto;
import com.sparta.boardv3.entity.Board;
import com.sparta.boardv3.entity.Comment;
import com.sparta.boardv3.entity.User;
import com.sparta.boardv3.repository.BoardRepository;
import com.sparta.boardv3.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public StatusDto createComment(Long id, CommentRequestDto requestDto, User user) {
        log.info("comment 등록 시도");
        Board board = boardRepository.findBoardById(id).orElseThrow(() ->
                new NullPointerException("해당 글을 찾을 수 없습니다.")
        );
        log.info("Board는 찾음");
        commentRepository.save(new Comment(requestDto, user, board));
        log.info("Comment 등록함");
        return new StatusDto("댓글 달기 성공", 200);
    }
}
