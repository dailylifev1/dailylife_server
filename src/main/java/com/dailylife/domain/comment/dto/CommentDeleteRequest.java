package com.dailylife.domain.comment.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "댓글을 삭제을 위한 객체")
public class CommentDeleteRequest {

    private Long commentNum;
}
