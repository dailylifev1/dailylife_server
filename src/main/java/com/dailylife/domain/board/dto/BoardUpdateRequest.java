package com.dailylife.domain.board.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardUpdateRequest {
    @NotBlank(message = "게시물 제목을 입력해주세요")
    @ApiModelProperty(notes = "게시물 제목을 입력해주세요")
    private String title;

    @NotBlank(message = "내용을 작성해주세요")
    @ApiModelProperty(notes = "내용을 작성해주세요")
    private String content;

    @NotBlank(message = "게시물 대표 사진을 등록해주세요")
    @ApiModelProperty(notes = "게시물 대표 사진을 등록해주세요")
    private String thumbNail;

    private Long boardNum;
}
