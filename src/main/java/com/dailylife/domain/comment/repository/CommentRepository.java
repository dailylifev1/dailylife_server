package com.dailylife.domain.comment.repository;

import com.dailylife.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentByBoardNum (Long boardNum);
    Comment findCommentByCommentNum(Long commentNum);
}
