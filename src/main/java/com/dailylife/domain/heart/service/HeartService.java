package com.dailylife.domain.heart.service;



import com.dailylife.domain.heart.dto.HeartStateRequest;
import org.springframework.stereotype.Service;

@Service
public interface HeartService {
    /*댓글 좋아요 UP / 좋아요 취소*/
    boolean heartPlusComment(HeartStateRequest heartStateRequest);
    /*게시글 좋아요 UP / 좋아요 취소*/
    boolean heartPlusBoard(HeartStateRequest heartStateRequest);

    boolean getHeart(Long userNum, Long boardNum);

    boolean heartPlusReply(HeartStateRequest heartStateRequest);

    Long heartCountComment(Long commentNum);

    Long heartCountBoard(Long boardNum);

    Long heartCountReply(Long replyNum);


}
