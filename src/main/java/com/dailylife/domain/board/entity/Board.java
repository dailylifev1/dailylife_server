package com.dailylife.domain.board.entity;

import com.dailylife.domain.board.dto.BoardCreateRequest;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private String userId;
    private String userNickName;
    private String thumNail;
    private Long likeCount;


    public static Board toEntity(BoardCreateRequest boardCreateRequest) {
        return  Board.builder()
                .title(boardCreateRequest.getTitle())
                .content(boardCreateRequest.getContent())
                .thumNail(boardCreateRequest.getThumNail()).build();

    }
}
