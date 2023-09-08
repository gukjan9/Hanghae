package com.sparta.boardv3.controller;

import com.sparta.boardv3.dto.BoardRequestDto;
import com.sparta.boardv3.dto.CommentRequestDto;
import com.sparta.boardv3.dto.CommentResponseDto;
import com.sparta.boardv3.dto.StatusDto;
import com.sparta.boardv3.entity.Comment;
import com.sparta.boardv3.security.UserDetailsImpl;
import com.sparta.boardv3.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;

    // 댓글 생성
    @PostMapping("/comments/{id}")
    public StatusDto createComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentService.createComment(id, requestDto, userDetails.getUser());
    }
}
