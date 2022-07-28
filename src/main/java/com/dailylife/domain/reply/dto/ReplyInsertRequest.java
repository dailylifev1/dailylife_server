package com.dailylife.domain.reply.dto;

import com.dailylife.domain.board.entity.Board;
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
@ApiModel(description = "댓글을 작성을 위한 객체")
public class ReplyInsertRequest {

    @NotBlank(message = "댓글 내용을 입력해주세요.")
    @ApiModelProperty(notes = "댓글 내용을 입력해주세요.")
    private String replyContext;

    private Long boardNum;

 /*   public ReplyReply toEntity(User user) {
        ReplyReply reply = new ReplyReply();
        reply.setReplyContext(replyContext);
        reply.setUser(user);
        reply.setReplyTime(LocalDateTime.now());
        reply.setBoardNum(boardNum);
        return reply;
    }*/

}
