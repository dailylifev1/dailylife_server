package com.dailylife.domain.replyReply.repository;

import com.dailylife.domain.replyReply.entity.ReplyReply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyReplyRepository extends JpaRepository<ReplyReply, Long> {
    List<ReplyReply> findByReplyNum (Long replyNum);
}
