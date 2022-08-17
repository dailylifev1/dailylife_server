package com.dailylife.domain.heart.repository;

import com.dailylife.domain.heart.entity.Heart;
import com.dailylife.domain.reply.entity.Reply;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface HeartRepository extends JpaRepository<Heart, Long> {

    int countByReplyReplyNumAndUserNum(Long replyNum, Long userNum); // 댓글 좋아요
    void deleteByReplyReplyNumAndUserNum(@Param(value="replyNum") Long replyNum, Long userNum); // 댓글 좋아요 취소

    int countByBoardBoardNumAndUserNum(Long boardNum, Long userNum); // 게시글 좋아요
    void deleteByBoardBoardNumAndUserNum(@Param(value="boardNum") Long boardNum, Long userNum); // 게시글 좋아요 취소

/*    int countByBoardNumAndUserNum(Long boardNum, Long userNum);

    void deleteByBoardNumAndUserNum(@Param(value = "boardNum") Long boardNum, Long userNum);*/
}
