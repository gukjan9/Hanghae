package com.sparta.boardv5.repository;

import com.sparta.boardv5.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByModifiedAtDesc();
    Optional<Board> findBoardById(Long id);
}