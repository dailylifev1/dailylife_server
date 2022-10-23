package com.dailylife.domain.reply.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "전체 댓글 리스트 응답을 위한 대댓글 객체 ")
@Builder
public class ReplyToCommentResponse {

    private Long id;
    private String content;

    private LocalDateTime localDateTime;

    private String username;
    private String thumbnail;

    public static ReplyToCommentResponse from (Long id , String content , String username , String thumbnail , LocalDateTime localDateTime) {

        return ReplyToCommentResponse.builder()
                .id(id)
                .content(content)
                .username(username)
                .thumbnail(thumbnail)
                .localDateTime(localDateTime)
                .build();

    }

}
