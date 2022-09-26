package com.dailylife.domain.comment.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "댓글을 확인을 위한 객체")
public class CommentGetRequest {

    @NotNull(message = "게시물(Board) 번호를 입력해주세요")
    @ApiModelProperty(notes = "게시물(Board) 번호를 입력해주세요")
    private Long boardNum;
}
