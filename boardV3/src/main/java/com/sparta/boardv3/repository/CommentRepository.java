package com.sparta.boardv3.repository;

import com.sparta.boardv3.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
