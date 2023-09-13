package com.sparta.boardv5.controller;

import com.sparta.boardv5.dto.BoardRequestDto;
import com.sparta.boardv5.dto.BoardResponseDto;
import com.sparta.boardv5.dto.StatusDto;
import com.sparta.boardv5.security.UserDetailsImpl;
import com.sparta.boardv5.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;

    // 게시글 생성
    @PostMapping("/boards")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return boardService.createBoard(requestDto, userDetails.getUser());
    }

    // 게시글 전체 조회
    @GetMapping("/boards")
    public List<BoardResponseDto> getBoards(){
        return boardService.getBoards();
    }

    // 게시글 개별 조회
    @GetMapping("/boards/{id}")
    public BoardResponseDto getBoardById(@PathVariable Long id){
        return boardService.getBoardById(id);
    }

    // 게시글 수정
    @PutMapping("/boards/{id}/")
    public BoardResponseDto updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return boardService.updateBoard(id, requestDto, userDetails.getUser());
    }

    @DeleteMapping("/boards/{id}")
    public StatusDto deleteBoard(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return boardService.deleteBoard(id, userDetails.getUser());
    }
}