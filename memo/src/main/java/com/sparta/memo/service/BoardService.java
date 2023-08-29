package com.sparta.memo.service;

import com.sparta.memo.dto.BoardRequestDto;
import com.sparta.memo.dto.BoardResponseDto;
import com.sparta.memo.entity.Board;
import com.sparta.memo.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository memoRepository) {
        this.boardRepository = memoRepository;
    }

    public BoardResponseDto createBoard(BoardRequestDto requestDto) {
        // RequestDto -> Entity
        Board board = new Board(requestDto);

        boardRepository.save(board);

        // Entity -> ResponseDto
        BoardResponseDto boardResponseDto = new BoardResponseDto(board);

        return boardResponseDto;
    }

    public BoardResponseDto getBoard(BoardResponseDto responseDto){
        Board board = new Board(responseDto);

        boardRepository.(board);
    }
}
