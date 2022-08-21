package com.dailylife.domain.reply.entity;

import com.dailylife.domain.heart.entity.Heart;
import com.dailylife.domain.reply.dto.ReplyInsertRequest;
import com.dailylife.domain.replyReply.entity.ReplyReply;
import com.dailylife.domain.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "tbl_reply")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyNum;

    private String replyContext;

    private LocalDateTime replyTime;

    private String replyState;

    private Long boardNum;


/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardNum")
    private Board board;*/


    @OneToMany(mappedBy = "reply" ,cascade = CascadeType.ALL) // reply이 삭제되면 자동으로 heart또한 삭제
    @JsonIgnore
    private List<Heart> hearts = new ArrayList<>();

    @OneToMany(mappedBy = "reply" ) // reply이 삭제되면 자동으로 replyReply또한 삭제(대댓글 삭제)
    @JsonIgnore
    private List<ReplyReply> replyReplies = new ArrayList<>();



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userNum")
    private User user;

    public static Reply toEntityReply(ReplyInsertRequest replyInsertRequest){
        return Reply.builder()
                .replyContext(replyInsertRequest.getReplyContext())
                .boardNum(replyInsertRequest.getBoardNum())
                .build();
    }
}