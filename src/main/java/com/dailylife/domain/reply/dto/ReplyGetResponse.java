package com.dailylife.domain.reply.dto;


import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.reply.entity.Reply;
import com.dailylife.domain.user.entity.User;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "게시물 작성시 응답 객체 ")
@Builder
public class ReplyGetResponse {
    private Long replyNum;

    private String replyContext;

    private LocalDateTime replyTime;

    private Long boardNum;

    private Long userNum;

    private String userName;

    public static ReplyGetResponse from(Reply reply, User user) {
        return ReplyGetResponse.builder()
                .replyNum(reply.getReplyNum())
                .replyContext(reply.getReplyContext())
                .replyTime(reply.getReplyTime())
                .boardNum(reply.getBoardNum())
                .userNum(user.getUserNum())
                .userName(user.getUserName()).build();
    }

}
