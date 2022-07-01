package com.dailylife.domain.user.entity;

import com.dailylife.domain.user.dto.UserJoinRequest;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

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

    public static User toEntity(UserJoinRequest userJoinRequest) {
        return  User.builder()
                .userId(userJoinRequest.getUserId())
                .userPassword(userJoinRequest.getUserPassword()).build();
    }

    //api localhost:8080
//    ddddd



}
