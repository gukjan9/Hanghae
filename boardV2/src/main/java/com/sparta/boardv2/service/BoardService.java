package com.sparta.boardv2.service;

import com.sparta.boardv2.dto.BoardRequestDto;
import com.sparta.boardv2.dto.BoardResponseDto;
import com.sparta.boardv2.dto.StatusDto;
import com.sparta.boardv2.entity.Board;
import com.sparta.boardv2.entity.User;
import com.sparta.boardv2.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardResponseDto createBoard(BoardRequestDto requestDto, User user) {
        Board board = boardRepository.save(new Board(requestDto, user));
        return new BoardResponseDto(board);
    }

    public List<BoardResponseDto> getBoards() {
        return boardRepository.findAllByOrderByModifiedAtDesc().stream().map(BoardResponseDto::new).toList();
    }

    public BoardResponseDto getBoardById(Long id){
        Board board = boardRepository.findBoardById(id).orElseThrow(() ->
                new RuntimeException("게시글이 존재하지 않습니다.")
                );
        return new BoardResponseDto(board);
    }

    @Transactional
    public BoardResponseDto updateBoard(Long id, BoardRequestDto requestDto, User user) {
        Board board = findBoard(id);

        if(board.getUser().getUsername().equals(user.getUsername())){
            board.update(requestDto);
            return new BoardResponseDto(board);
        }
        else{
            throw new IllegalArgumentException("게시글 수정 권한이 없습니다.");
        }
    }

    @Transactional
    public StatusDto deleteBoard(Long id, User user) {
        Board board = findBoard(id);

        if(board.getUser().getUsername().equals(user.getUsername())){
            boardRepository.delete(board);
            return new StatusDto("삭제 성공", 200);
        }
        else{
            return new StatusDto("삭제 실패", 400);
        }

    }

    private Board findBoard(Long id) {
        return boardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 Board는 존재하지 않습니다.")
        );
    }
}