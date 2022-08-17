package com.dailylife.domain.heart.entity;

import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.heart.dto.HeartStateRequest;
import com.dailylife.domain.reply.entity.Reply;

import com.dailylife.domain.user.entity.User;
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
    @JoinColumn(name="replyNum")
    private Reply reply;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="boardNum")
    private Board board;

    private Long userNum;

    private Long heartState;

    public static Heart toEntityReply(HeartStateRequest heartStateRequest, Reply reply){
        Heart build =  Heart.builder()
                .heartState(heartStateRequest.getHeartState())
                .userNum(heartStateRequest.getUserNum())
                .build();
        build.setReply(reply);
        return build;
    }

    public static Heart toEntityBoard(HeartStateRequest heartStateRequest, Board board){
        Heart build =  Heart.builder()
                .heartState(heartStateRequest.getHeartState())
                .userNum(heartStateRequest.getUserNum())
                .build();
        build.setBoard(board);
        return build;
    }



}
