package com.dailylife.domain.user.entity;

import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.user.dto.UserJoinRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

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

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Board> boards = new ArrayList<>();

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


}
