package com.dailylife.domain.comment.dto;


import com.dailylife.domain.board.entity.Board;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "특정 게시물에 해당 하는 댓글 리스트 응답객체")
@Builder
public class CommentGetResponse {
    private Long boardNum;

        private String boardContent;

        private LocalDateTime commentTime;

        private List<CommentContentResponse> replies = new ArrayList<>();

        public static CommentGetResponse from(List<CommentContentResponse> commentList, Board board) {
            return CommentGetResponse.builder()
                    .boardNum(board.getBoardNum())
                .boardContent(board.getContent())
                .replies(commentList).build();
    }

}
