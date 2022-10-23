package com.dailylife.domain.reply.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "대댓글을 삭제을 위한 객체")
@Builder
public class ReplyToCommentResponse {

    private Long id;
    private String content;

    public static ReplyToCommentResponse from (Long id , String content) {

        return ReplyToCommentResponse.builder()
                .id(id)
                .content(content).build();
    }

}
