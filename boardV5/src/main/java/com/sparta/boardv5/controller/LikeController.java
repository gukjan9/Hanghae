package com.sparta.boardv5.controller;

import com.sparta.boardv5.dto.CommentRequestDto;
import com.sparta.boardv5.dto.CommentResponseDto;
import com.sparta.boardv5.dto.StatusDto;
import com.sparta.boardv5.security.UserDetailsImpl;
import com.sparta.boardv5.service.CommentService;
import com.sparta.boardv5.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LikeController {
    private final LikeService likeService;

    // 댓글 생성
    @PostMapping("/like/{id}")
    public StatusDto likeBoard(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        likeService.likeBoard(id, userDetails.getUser());
        return new StatusDto("좋아요 성공", 200);
    }
}
