package com.dailylife.domain.user.dto;

import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.user.entity.User;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "유저의 대한 상세정보를 전달하기위한 객체")
@Builder
public class UserDetailResponse {

    private String userId;
    private String userName;
    private String userEmail;
    private String userProfileImg;

    private int followSize;
    private int followerSize;

    private Long boardNum;

    public static UserDetailResponse from(User user , int followSize , int followerSize , Board board) {
        return UserDetailResponse.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .userEmail(user.getUserEmail())
                .userProfileImg(user.getUserProfileImg())
                .followerSize(followerSize)
                .followSize(followSize)
                .boardNum(board.getBoardNum()).build();
    }

}
