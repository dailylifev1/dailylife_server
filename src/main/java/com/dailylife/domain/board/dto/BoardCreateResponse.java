package com.dailylife.domain.board.dto;


import com.dailylife.domain.board.entity.Board;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "게시물 작성시 응답 객체 ")
@Builder
public class BoardCreateResponse {

    private String title;
    private String content;
    private List<String> originalFileName;

    public static BoardCreateResponse from(Board board , List<String> originalFileName) {
        return BoardCreateResponse.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .originalFileName(originalFileName).build();
    }

}
