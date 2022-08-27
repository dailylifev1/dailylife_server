package com.dailylife.domain.reply.repository;

import com.dailylife.domain.reply.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findReplyByBoardNum (Long boardNum);
}
