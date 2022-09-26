package com.dailylife.domain.heart.service;

import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.heart.dto.HeartStateRequest;
import com.dailylife.domain.heart.entity.Heart;
import com.dailylife.domain.heart.repository.HeartRepository;
import com.dailylife.domain.comment.entity.Comment;
import com.dailylife.domain.reply.entity.Reply;
import com.dailylife.domain.user.entity.User;
import com.dailylife.domain.user.repository.UserRepository;
import com.dailylife.global.jwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public boolean heartPlusComment(HeartStateRequest heartStateRequest) {
        Comment comment = new Comment();
        comment.setCommentNum(heartStateRequest.getCommentNum());
        User user = userRepository.findByUserId(jwtService.getLoginId());
        heartStateRequest.setUserNum(user.getUserNum());
        if(heartRepository.countByCommentCommentNumAndUserNum(comment.getCommentNum(), user.getUserNum()) == 0){
            heartStateRequest.setHeartState(1L);
            Heart heart = heartRepository.save(Heart.toEntityComment(heartStateRequest, comment));
            return true;
        }
        else {
          heartRepository.deleteByCommentCommentNumAndUserNum(comment.getCommentNum(), user.getUserNum());
            return false;
        }

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
            return true;
        }else {
            heartRepository.deleteByBoardBoardNumAndUserNum(board.getBoardNum(), user.getUserNum());
            return false;
        }
    }

    /*대댓글 좋아요*/
    @Override
    @Transactional
    public boolean heartPlusReply(HeartStateRequest heartStateRequest) {
        Reply reply = new Reply();
        reply.setReplyNum(heartStateRequest.getReplyNum());
        User user = userRepository.findByUserId(jwtService.getLoginId());
        heartStateRequest.setUserNum(user.getUserNum());
        if(heartRepository.countByReplyReplyNumAndUserNum(reply.getReplyNum(),user.getUserNum())==0){
            heartStateRequest.setHeartState(1L);
            Heart heart = heartRepository.save(Heart.toEntityReply(heartStateRequest, reply));
            return true;
        }else{
            heartRepository.deleteByReplyReplyNumAndUserNum(reply.getReplyNum(),user.getUserNum());
            return false;
        }

    }

    /*댓글 좋아요 총 개수 출력*/
    @Override
    @Transactional
    public Long heartCountComment(Long commentNum) {
        Long heartCount = heartRepository.countByCommentCommentNum(commentNum);
        return heartCount;
    }
    /*게시글 좋아요 총 개수 출력*/
    @Override
    @Transactional
    public Long heartCountBoard(Long boardNum) {
        Long heartCount = heartRepository.countByBoardBoardNum(boardNum);
        return heartCount;
    }

    /*대댓글 좋아요 총 개수 출력*/
    @Override
    @Transactional
    public Long heartCountReply(Long replyNum) {
        Long heartCount = heartRepository.countByReplyReplyNum(replyNum);
        return heartCount;
    }

    @Override
    @Transactional
    public boolean getHeart(Long userNum, Long boardNum) {
        if(heartRepository.findHeartStateByUserNumAndBoardBoardNum(userNum, boardNum).isEmpty()){
            return false;
        }else return true;
    }
}
