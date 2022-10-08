package com.dailylife.domain.reply.entity;

import com.dailylife.domain.comment.entity.Comment;
import com.dailylife.domain.heart.entity.Heart;
import com.dailylife.domain.reply.dto.ReplyInsertRequest;
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

    private String userName;

/*    @OneToMany(mappedBy = "comment" ) // replyReply이 삭제되면 자동으로 heart또한 삭제
    @JsonIgnore
    private List<Heart> hearts = new ArrayList<>();*/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userNum")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER) // reply이 삭제되면 자동으로 replyReply또한 삭제
    @JoinColumn(name="commentNum") // 상위 댓글 replyNum
    private Comment comment;

//    @OneToMany(mappedBy = "comment")
//    @JsonIgnore
//    private List<Heart> hearts = new ArrayList<>();

    public static Reply toEntityReply(ReplyInsertRequest replyInsertRequest, User user, Comment comment){
        Reply build = Reply.builder()
                .replyContext(replyInsertRequest.getReplyContext())
                .replyNum(replyInsertRequest.getCommentNum())
                .replyTime(LocalDateTime.now())
                .userName(user.getUserName())
                .build();
        build.setUser(user);
        build.setComment(comment);
        return build;
    }

}