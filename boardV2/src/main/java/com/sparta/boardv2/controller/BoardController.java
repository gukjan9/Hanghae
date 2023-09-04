package com.sparta.boardv2.controller;

import com.sparta.boardv2.dto.BoardRequestDto;
import com.sparta.boardv2.dto.BoardResponseDto;
import com.sparta.boardv2.security.UserDetailsImpl;
import com.sparta.boardv2.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/boards")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return boardService.createBoard(requestDto, userDetails.getUser());
    }

    @GetMapping("/boards")
    public List<BoardResponseDto> getBoards() {
        return boardService.getBoards();
    }

//    @PutMapping("/boards/{id}")
//    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
//        return boardService.updateBoard(id, requestDto);
//    }
//
//    @DeleteMapping("/boards/{id}")
//    public Long deleteBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
//        return boardService.deleteBoard(id, requestDto);
//    }
}