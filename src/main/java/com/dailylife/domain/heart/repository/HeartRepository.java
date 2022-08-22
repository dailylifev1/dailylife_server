package com.dailylife.domain.heart.repository;

import com.dailylife.domain.heart.entity.Heart;
import com.dailylife.domain.reply.entity.Reply;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface HeartRepository extends JpaRepository<Heart, Long> {

    int countByReplyReplyNumAndUserNum(Long replyNum, Long userNum); // 댓글 좋아요
    void deleteByReplyReplyNumAndUserNum(@Param(value="replyNum") Long replyNum, Long userNum); // 댓글 좋아요 취소

    int countByBoardBoardNumAndUserNum(Long boardNum, Long userNum); // 게시글 좋아요
    void deleteByBoardBoardNumAndUserNum(@Param(value="boardNum") Long boardNum, Long userNum); // 게시글 좋아요 취소
    
   /* int countByReplyReplyReplyReplyNumAndUserNum(Long replyReplyNum, Long userNum); // 대댓글 좋아요
    
    void deleteByReplyReplyReplyReplyNumAndUserNum(@Param(value="replyReplyNum") Long replyReplyNum, Long userNum); // 대댓글 좋아요 취소*/

    Long countByReplyReplyNum(Long replyNum); // 댓글 좋아요 총 갯수 출력

    Long countByBoardBoardNum(Long boardNum); // 게시글 좋아요 총 갯수 출력

    Optional<Long> findHeartStateByUserNumAndBoardBoardNum(Long userNum, Long boardNum);

    /*Long countByReplyReplyReplyReplyNum(Long replyReplyNum); // 대댓글 좋아요 총 개수 출력*/

}
