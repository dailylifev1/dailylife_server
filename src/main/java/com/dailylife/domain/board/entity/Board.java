package com.dailylife.domain.board.entity;

import com.dailylife.domain.board.dto.BoardCreateRequest;
import com.dailylife.domain.board.dto.BoardUpdateRequest;
import com.dailylife.domain.heart.entity.Heart;
import com.dailylife.domain.image.entity.Image;
import com.dailylife.domain.reply.entity.Reply;
import com.dailylife.domain.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tbl_board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNum;
    private String title;
    private String content;
    private String userNickName;
    private String thumbNail;
    private Long likeCount;
    private Long fileId;

    @ManyToOne
    @JoinColumn(name = "uno")
    User user;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Image> images = new ArrayList<>();

    @OneToMany(mappedBy = "board" ,cascade = CascadeType.ALL) // board이(가) 삭제되면 자동으로 heart또한 삭제
    @JsonIgnore
    private List<Heart> hearts = new ArrayList<>();

   /* @OneToMany(mappedBy = "board")
    @JsonIgnore
    private List<ReplyReply> replies = new ArrayList<>();*/

    public void setUser(User user) {
        this.user = user;
        user.getBoards().add(this);
    }




    public static Board toEntity(BoardCreateRequest boardCreateRequest ,User user) {
        Board build = Board.builder()
                .title(boardCreateRequest.getTitle())
                .content(boardCreateRequest.getContent())
                .thumbNail(boardCreateRequest.getThumbNail())
                .build();
        build.setUser(user);

        return build;
    }
//save로 수정 버전
    public static Board toEntityUpdate(BoardUpdateRequest boardUpdateRequest) {
        return  Board.builder()
                .boardNum(boardUpdateRequest.getBoardNum())
                .title(boardUpdateRequest.getTitle())
                .content(boardUpdateRequest.getContent())
                .thumbNail(boardUpdateRequest.getThumbNail()).build();
    }

}
