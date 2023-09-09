package com.sparta.boardv3.repository;

import com.sparta.boardv3.entity.Board;
import com.sparta.boardv3.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findCommentById(Long id);
}
