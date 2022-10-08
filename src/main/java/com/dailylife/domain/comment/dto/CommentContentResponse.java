package com.dailylife.domain.comment.dto;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentContentResponse {

    private Long commentId;
    private String commentIdContent;

    public static CommentContentResponse from(Long id , String content) {

        return CommentContentResponse.builder()
                .commentId(id)
                .commentIdContent(content).build();
    }

}
