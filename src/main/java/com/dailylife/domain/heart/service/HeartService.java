package com.dailylife.domain.heart.service;



import com.dailylife.domain.heart.dto.HeartStateRequest;
import com.dailylife.domain.heart.repository.HeartRepository;
import com.dailylife.domain.reply.entity.Reply;
import org.springframework.stereotype.Service;

@Service
public interface HeartService {
    /*댓글 좋아요 UP / 좋아요 취소*/
    boolean heartPlusReply(HeartStateRequest heartStateRequest);
    /*게시글 좋아요 UP / 좋아요 취소*/
    boolean heartPlusBoard(HeartStateRequest heartStateRequest);

    boolean getHeart(Long userNum, Long boardNum);

/*    boolean heartPlusReplyReply(HeartStateRequest heartStateRequest);*/

    Long heartCountReply(Long replyNum);

    Long heartCountBoard(Long boardNum);

/*    Long heartCountReplyReply(Long replyReplyNum);*/


}
