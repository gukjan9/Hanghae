package com.sparta.boardv5.service;

import com.sparta.boardv5.dto.*;
import com.sparta.boardv5.entity.Board;
import com.sparta.boardv5.entity.Comment;
import com.sparta.boardv5.entity.User;
import com.sparta.boardv5.entity.UserRoleEnum;
import com.sparta.boardv5.repository.BoardRepository;
import com.sparta.boardv5.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public CommentResponseDto createComment(Long id, CommentRequestDto requestDto, User user) {
        Board board = boardRepository.findBoardById(id).orElseThrow(() ->
                new NullPointerException("해당 글을 찾을 수 없습니다.")
        );
        Comment comment = commentRepository.save(new Comment(requestDto, user, board));
        return new CommentResponseDto(comment);
    }

    @Transactional
    public CommentResponseDto updateComment(Long id, CommentRequestDto requestDto, User user) {
        Comment comment = findComment(id);

        if(user.getRole().equals(UserRoleEnum.ADMIN) || comment.getUser().getUsername().equals(user.getUsername())){
            comment.update(requestDto);
            return new CommentResponseDto(comment);
        }
        else{
            throw new IllegalArgumentException("댓글 수정 권한이 없습니다.");
        }
    }

    public StatusDto deleteBoard(Long id, User user) {
        Comment comment = findComment(id);

        if(user.getRole().equals(UserRoleEnum.ADMIN) || comment.getUser().getUsername().equals(user.getUsername())){
            commentRepository.delete(comment);
            return new StatusDto("삭제 성공", 200);
        }
        else{
            return new StatusDto("댓글 삭제 권한이 없습니다", 400);
        }
    }

    private Comment findComment(Long id) {
        return commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글을 찾을 수 없습니다.")
        );
    }
}
