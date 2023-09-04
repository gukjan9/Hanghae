package com.sparta.boardv2.service;

import com.sparta.boardv2.dto.BoardRequestDto;
import com.sparta.boardv2.dto.BoardResponseDto;
import com.sparta.boardv2.entity.Board;
import com.sparta.boardv2.entity.User;
import com.sparta.boardv2.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardResponseDto createBoard(BoardRequestDto requestDto, User user) {
        Board board = boardRepository.save(new Board(requestDto, user));
        return new BoardResponseDto(board);
    }

    public List<BoardResponseDto> getBoards() {
        // DB 조회
        return boardRepository.findAllByOrderByModifiedAtDesc().stream().map(BoardResponseDto::new).toList();
    }

    public List<BoardResponseDto> getBoardsByKeyword(String keyword) {
        return boardRepository.findAllByContentsContainsOrderByModifiedAtDesc(keyword).stream().map(BoardResponseDto::new).toList();
    }

//    @Transactional
//    public Long updateBoard(Long id, BoardRequestDto requestDto) {
//        // 해당 메모가 DB에 존재하는지 확인
//        Board board = findBoard(id);
//
//        if(requestDto.getPassword().equals(board.getPassword())){
//            // memo 내용 수정
//            board.update(requestDto);
//            return id;
//        }
//        else{
//            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
//        }
//    }

//    public Long deleteBoard(Long id, BoardRequestDto requestDto) {
//        // 해당 메모가 DB에 존재하는지 확인
//        Board board = findBoard(id);
//
//        if(requestDto.getPassword().equals(board.getPassword())){
//            // memo 삭제
//            boardRepository.delete(board);
//            return id;
//        }
//        else{
//            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
//        }
//
//    }

    private Board findBoard(Long id) {
        return boardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 Board는 존재하지 않습니다.")
        );
    }
}