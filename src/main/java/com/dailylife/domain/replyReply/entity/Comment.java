package com.dailylife.domain.replyReply.entity;

import com.dailylife.domain.reply.entity.Reply;
import com.dailylife.domain.replyReply.dto.ReplyReplyInsertRequest;
import com.dailylife.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity(name = "tbl_replyReply")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyReplyNum;

    private String replyReplyContext;

    private LocalDateTime replyReplyTime;

    private String replyReplyState;

   private Long replyNum;



/*    @OneToMany(mappedBy = "comment" ) // replyReply이 삭제되면 자동으로 heart또한 삭제
    @JsonIgnore
    private List<Heart> hearts = new ArrayList<>();*/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userNum")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER) // reply이 삭제되면 자동으로 replyReply또한 삭제
    @JoinColumn(name="parentReplyNum") // 상위 댓글 replyNum
    private Reply reply;

/*    @OneToMany(mappedBy = "comment")
    @JsonIgnore
    private List<Heart> hearts = new ArrayList<>();*/

    public static Comment toEntityReplyReply(ReplyReplyInsertRequest replyInsertRequest, User user, Reply reply){
        Comment build = Comment.builder()
                .replyReplyContext(replyInsertRequest.getReplyReplyContext())
                .replyNum(replyInsertRequest.getReplyNum())
                .replyReplyTime(LocalDateTime.now())
                .build();
        build.setUser(user);
        build.setReply(reply);
        return build;
    }
}