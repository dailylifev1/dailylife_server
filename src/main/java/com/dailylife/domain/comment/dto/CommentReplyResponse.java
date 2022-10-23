package com.dailylife.domain.comment.dto;

import com.dailylife.domain.reply.dto.ReplyToCommentResponse;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentReplyResponse {

    private Long id;
    private String content;
    private LocalDateTime date;
    private String username;
    private String thumbnail;
    private List<ReplyToCommentResponse> replies = new ArrayList<>();

    public static CommentReplyResponse from(Long id , String content , String username , String  thumbnail , LocalDateTime date ,
                                            List<ReplyToCommentResponse> replies) {

        return CommentReplyResponse.builder()
                .id(id)
                .content(content)
                .date(date)
                .replies(replies).build();

    }

}
