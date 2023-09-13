package com.sparta.boardv5.repository;

import com.sparta.boardv5.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findCommentById(Long id);
}
