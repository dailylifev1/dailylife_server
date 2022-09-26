package com.dailylife.domain.reply.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "대댓글을 삭제을 위한 객체")
public class ReplyDeleteRequest {

    private Long replyNum;
}
