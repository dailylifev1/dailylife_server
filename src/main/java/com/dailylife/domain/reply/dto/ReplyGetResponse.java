package com.dailylife.domain.reply.dto;


import com.dailylife.domain.comment.entity.Comment;
import com.dailylife.domain.reply.entity.Reply;
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
public class ReplyGetResponse {
    private Long replyNum;

    private Long commentNum; // 댓글 번호

    private String replyContext;

    private LocalDateTime replyTime;

    private Long userNum;

    private String userName;

    public static ReplyGetResponse from(Reply reply, User user, Comment comment) {
        return ReplyGetResponse.builder()
                .replyNum(reply.getReplyNum())
                .replyContext(reply.getReplyContext())
                .replyTime(reply.getReplyTime())
                .commentNum(comment.getCommentNum())
                .userNum(user.getUserNum())
                .userName(user.getUserName()).build();
    }

}
