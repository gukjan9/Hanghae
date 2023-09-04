package com.sparta.boardv2.controller;

import com.sparta.boardv2.dto.BoardRequestDto;
import com.sparta.boardv2.dto.BoardResponseDto;
import com.sparta.boardv2.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/boards")
    public ResponseEntity<BoardResponseDto> createBoard(@RequestBody BoardRequestDto requestDto) {
        return ResponseEntity.ok(boardService.createBoard(requestDto));
    }

    @GetMapping("/boards")
    public List<BoardResponseDto> getBoards() {
        return boardService.getBoards();
    }

    @GetMapping("/boards/contents")
    public List<BoardResponseDto> getBoardsByKeyword(String keyword) {
        return boardService.getBoardsByKeyword(keyword);
    }

    @PutMapping("/boards/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.updateBoard(id, requestDto);
    }

    @DeleteMapping("/boards/{id}")
    public Long deleteBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.deleteBoard(id, requestDto);
    }
}