package com.sparta.boardv3.repository;

import com.sparta.boardv3.entity.Board;
import com.sparta.boardv3.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByModifiedAtDesc();
    Optional<Board> findBoardById(Long id);
}