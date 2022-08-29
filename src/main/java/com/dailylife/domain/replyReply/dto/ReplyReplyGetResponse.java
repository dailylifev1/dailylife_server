package com.dailylife.domain.replyReply.dto;


import com.dailylife.domain.reply.entity.Reply;
import com.dailylife.domain.replyReply.entity.Comment;
import com.dailylife.domain.user.entity.User;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "게시물 작성시 응답 객체 ")
@Builder
public class ReplyReplyGetResponse {
    private Long replyReplyNum;

    private Long parentReplyNum;

    private String replyReplyContext;

    private LocalDateTime replyReplyTime;

    private Long userNum;

    private String userName;

    public static ReplyReplyGetResponse from(Comment comment, User user) {
        return ReplyReplyGetResponse.builder()
                .replyReplyNum(comment.getReplyReplyNum())
                .replyReplyContext(comment.getReplyReplyContext())
                .replyReplyTime(comment.getReplyReplyTime())
                .parentReplyNum(comment.getReplyNum())
                .userNum(user.getUserNum())
                .userName(user.getUserName()).build();
    }

}
