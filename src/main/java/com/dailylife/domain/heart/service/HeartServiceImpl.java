package com.dailylife.domain.heart.service;

import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.heart.dto.HeartStateRequest;
import com.dailylife.domain.heart.entity.Heart;
import com.dailylife.domain.heart.repository.HeartRepository;
import com.dailylife.domain.reply.entity.Reply;
import com.dailylife.domain.replyReply.entity.ReplyReply;
import com.dailylife.domain.user.entity.User;
import com.dailylife.domain.user.repository.UserRepository;
import com.dailylife.global.jwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class HeartServiceImpl implements HeartService{

    private final HeartRepository heartRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    /*댓글 좋아요 */
    @Override
    @Transactional
    public boolean heartPlusReply(HeartStateRequest heartStateRequest) {
        Reply reply = new Reply();
        reply.setReplyNum(heartStateRequest.getReplyNum());
        User user = userRepository.findByUserId(jwtService.getLoginId());
        heartStateRequest.setUserNum(user.getUserNum());
        if(heartRepository.countByReplyReplyNumAndUserNum(reply.getReplyNum(), user.getUserNum()) == 0){
            heartStateRequest.setHeartState(1L);
            Heart heart = heartRepository.save(Heart.toEntityReply(heartStateRequest, reply));
        }
        else {
          heartRepository.deleteByReplyReplyNumAndUserNum(reply.getReplyNum(), user.getUserNum());
        }
        return true;

    }
    /*게시글 좋아요*/
    @Override
    @Transactional
    public boolean heartPlusBoard(HeartStateRequest heartStateRequest) {
        Board board = new Board();
        board.setBoardNum(heartStateRequest.getBoardNum());
        User user = userRepository.findByUserId(jwtService.getLoginId());
        heartStateRequest.setUserNum(user.getUserNum());
        if(heartRepository.countByBoardBoardNumAndUserNum(board.getBoardNum(),user.getUserNum())==0){
            heartStateRequest.setHeartState(1L);
            Heart heart = heartRepository.save(Heart.toEntityBoard(heartStateRequest,board));
        }else {
            heartRepository.deleteByBoardBoardNumAndUserNum(board.getBoardNum(), user.getUserNum());
        }
        return true;
    }

    /*대댓글 좋아요*//*
    @Override
    @Transactional
    public boolean heartPlusReplyReply(HeartStateRequest heartStateRequest) {
        ReplyReply replyReply = new ReplyReply();
        replyReply.setReplyReplyNum(heartStateRequest.getReplyReplyNum());
        User user = userRepository.findByUserId(jwtService.getLoginId());
        heartStateRequest.setUserNum(user.getUserNum());
        if(heartRepository.countByReplyReplyReplyReplyNumAndUserNum(replyReply.getReplyReplyNum(),user.getUserNum())==0){
            heartStateRequest.setHeartState(1L);
            Heart heart = heartRepository.save(Heart.toEntityReplyReply(heartStateRequest,replyReply));
        }else{
            heartRepository.deleteByReplyReplyReplyReplyNumAndUserNum(replyReply.getReplyReplyNum(),user.getUserNum());
        }
        return true;
    }*/

    /*댓글 좋아요 총 개수 출력*/
    @Override
    @Transactional
    public Long heartCountReply(Long replyNum) {
        Long heartCount = heartRepository.countByReplyReplyNum(replyNum);
        return heartCount;
    }
    /*게시글 좋아요 총 개수 출력*/
    @Override
    @Transactional
    public Long heartCountBoard(Long boardNum) {
        Long heartCount = heartRepository.countByBoardBoardNum(boardNum);
        return heartCount;
    }
/*
    *//*대댓글 좋아요 총 개수 출력*//*
    @Override
    @Transactional
    public Long heartCountReplyReply(Long replyReplyNum) {
        Long heartCount = heartRepository.countByReplyReplyReplyReplyNum(replyReplyNum);
        return heartCount;
    }*/

}
