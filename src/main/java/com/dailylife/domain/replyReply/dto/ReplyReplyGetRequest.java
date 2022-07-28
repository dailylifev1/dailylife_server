package com.dailylife.domain.replyReply.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "대댓글을 확인을 위한 객체")
public class ReplyReplyGetRequest {

    @NotNull(message = "댓글(reply) 번호(replyNum)를 입력해주세요")
    @ApiModelProperty(notes = "댓글(reply) 번호(replyNum)를 입력해주세요")
    private Long replyNum;
}
