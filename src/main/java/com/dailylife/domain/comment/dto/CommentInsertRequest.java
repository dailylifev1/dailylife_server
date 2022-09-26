package com.dailylife.domain.comment.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "댓글을 작성을 위한 객체")
public class CommentInsertRequest {

    @NotBlank(message = "댓글 내용을 입력해주세요.")
    @ApiModelProperty(notes = "댓글 내용을 입력해주세요.")
    private String replyContext;

    private Long boardNum;



}
