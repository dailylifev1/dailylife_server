package com.dailylife.domain.reply.dto;

import com.dailylife.domain.reply.entity.Reply;
import com.dailylife.domain.user.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "댓글을 삭제을 위한 객체")
public class ReplyDeleteRequest {

    private Long replyId;
}
