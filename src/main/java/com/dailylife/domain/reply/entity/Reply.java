package com.dailylife.domain.reply.entity;

import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.reply.dto.ReplyInsertRequest;
import com.dailylife.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;



@Entity(name = "tbl_reply")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;

    private String replyContext;

    private LocalDateTime replyTime;

    private String replyState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bno")
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="uno")
    private User user;

    public static Reply toEntityReply(ReplyInsertRequest replyInsertRequest){
        return Reply.builder()
                .replyContext(replyInsertRequest.getReplyContext()).build();
    }
}