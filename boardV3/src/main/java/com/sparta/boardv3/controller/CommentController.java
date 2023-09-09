package com.sparta.boardv3.controller;

import com.sparta.boardv3.dto.*;
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

    // 댓글 수정
    @PutMapping("/comments/{id}")
    public StatusDto updateBoard(@PathVariable Long id, @RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentService.updateComment(id, requestDto, userDetails.getUser());
    }
}
