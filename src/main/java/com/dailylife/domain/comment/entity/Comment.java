package com.dailylife.domain.comment.entity;

import com.dailylife.domain.heart.entity.Heart;
import com.dailylife.domain.comment.dto.CommentInsertRequest;
import com.dailylife.domain.reply.entity.Reply;
import com.dailylife.domain.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "tbl_comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNum;

    private String commentContext;

    private LocalDateTime commentTime;

    private Long boardNum;

    private String userName;



    @OneToMany(mappedBy = "comment" ,cascade = CascadeType.ALL) // reply이 삭제되면 자동으로 heart또한 삭제
    @JsonIgnore
    private List<Heart> hearts = new ArrayList<>();

    @OneToMany(mappedBy = "comment" ) // comment이 삭제되면 자동으로 reply또한 삭제(대댓글 삭제)
    @JsonIgnore
    private List<Reply> replyComments = new ArrayList<>();



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userNum")
    private User user;

    public static Comment toEntityComment(CommentInsertRequest commentInsertRequest, User user){
        Comment build= Comment.builder()
                .commentContext(commentInsertRequest.getReplyContext())
                .boardNum(commentInsertRequest.getBoardNum())
                .commentTime(LocalDateTime.now())
                .userName(user.getUserName())
                .build();
        build.setUser(user);
        return build;
    }
}