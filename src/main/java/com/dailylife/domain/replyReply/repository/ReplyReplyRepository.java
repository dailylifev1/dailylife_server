package com.dailylife.domain.replyReply.repository;

import com.dailylife.domain.replyReply.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyReplyRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByReplyNum (Long replyNum);
}
