package com.dailylife.domain.user.entity;

import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.reply.entity.Reply;
import com.dailylife.domain.user.dto.UserJoinRequest;
import com.dailylife.domain.follow.entity.Follow;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tbl_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNum;

    private String userId;

    private String userName;

    private String userPassword;

    private String userPhoneNumber;

    private String userEmail;

    private LocalDateTime userJoinDate;

    private String userProfileImg;

    private String accessToken;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "user" , orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Follow> follows = new ArrayList<>();

    @OneToMany(mappedBy = "user" , orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Reply> replies = new ArrayList<>();




    public static User toEntity(UserJoinRequest userJoinRequest) {
        return  User.builder()
                .userId(userJoinRequest.getUserId())
                .userPassword(userJoinRequest.getUserPassword())
                .userName(userJoinRequest.getUserName())
                .userPhoneNumber(userJoinRequest.getUserPhoneNumber())
                .userEmail(userJoinRequest.getUserEmail())
                .userJoinDate(LocalDateTime.now())
                .build();
    }

    /*
     public static User toEntity(UserJoinReq userJoinReq) {
        return  User.builder()
                .name(userJoinReq.getName())
                .build();
    }
     */


}
