package com.dailylife.domain.heart.entity;

import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.heart.dto.HeartStateRequest;
import com.dailylife.domain.comment.entity.Comment;

import com.dailylife.domain.reply.entity.Reply;
import lombok.*;

import javax.persistence.*;

@Entity(name = "tbl_heart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Heart {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long heartNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="commentNum")
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="boardNum")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="replyNum")
    private Reply reply;

    private Long userNum;

    private Long heartState;

    //댓글 좋아요
    public static Heart toEntityComment(HeartStateRequest heartStateRequest, Comment comment){
        Heart build =  Heart.builder()
                .heartState(heartStateRequest.getHeartState())
                .userNum(heartStateRequest.getUserNum())
                .build();
        build.setComment(comment);
        return build;
    }

    //게시글 좋아요
    public static Heart toEntityBoard(HeartStateRequest heartStateRequest, Board board){
        Heart build =  Heart.builder()
                .heartState(heartStateRequest.getHeartState())
                .userNum(heartStateRequest.getUserNum())
                .build();
        build.setBoard(board);
        return build;
    }

    //대댓글 좋아요
    public static Heart toEntityReply(HeartStateRequest heartStateRequest, Reply reply){
        Heart build = Heart.builder()
                .heartState(heartStateRequest.getHeartState())
                .userNum(heartStateRequest.getUserNum())
                .build();
        build.setReply(reply);
        return build;
    }



}
