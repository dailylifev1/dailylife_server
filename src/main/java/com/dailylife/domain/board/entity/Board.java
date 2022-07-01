package com.dailylife.domain.board.entity;

import com.dailylife.domain.board.dto.BoardCreateRequest;
import com.dailylife.domain.board.dto.BoardUpdateRequest;
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
    private String thumbNail;
    private Long likeCount;
    private String originFileName;
    private String fullPath;


    public static Board toEntity(BoardCreateRequest boardCreateRequest) {
        return  Board.builder()
                .title(boardCreateRequest.getTitle())
                .content(boardCreateRequest.getContent())
                .thumbNail(boardCreateRequest.getThumbNail()).build();

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
