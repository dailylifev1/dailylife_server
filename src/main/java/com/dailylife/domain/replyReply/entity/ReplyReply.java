package com.dailylife.domain.replyReply.entity;

import com.dailylife.domain.heart.entity.Heart;
import com.dailylife.domain.reply.entity.Reply;
import com.dailylife.domain.replyReply.dto.ReplyReplyInsertRequest;
import com.dailylife.domain.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "tbl_replyReply")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyReply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyReplyNum;

    private String replyReplyContext;

    private LocalDateTime replyReplyTime;

    private String replyReplyState;

   private Long replyNum;



/*    @OneToMany(mappedBy = "replyReply" ) // replyReply이 삭제되면 자동으로 heart또한 삭제
    @JsonIgnore
    private List<Heart> hearts = new ArrayList<>();*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userNum")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY) // reply이 삭제되면 자동으로 replyReply또한 삭제
    @JoinColumn(name="parentReplyNum") // 상위 댓글 replyNum
    private Reply reply;

    public static ReplyReply toEntityReplyReply(ReplyReplyInsertRequest replyInsertRequest){
        return ReplyReply.builder()
                .replyReplyContext(replyInsertRequest.getReplyReplyContext())
                .replyNum(replyInsertRequest.getReplyNum())
                .build();
    }
}