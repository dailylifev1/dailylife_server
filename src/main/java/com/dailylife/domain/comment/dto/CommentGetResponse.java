package com.dailylife.domain.comment.dto;


import com.dailylife.domain.comment.entity.Comment;
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
public class CommentGetResponse {
    private Long commentNum;

    private String commentContext;

    private LocalDateTime commentTime;

    private Long boardNum;

    private Long userNum;

    private String userName;


    public static CommentGetResponse from(Comment comment, User user) {
        return CommentGetResponse.builder()
                .commentNum(comment.getCommentNum())
                .commentContext(comment.getCommentContext())
                .commentTime(comment.getCommentTime())
                .boardNum(comment.getBoardNum())
                .userNum(user.getUserNum())
                .userName(user.getUserName()).build();
    }

}
