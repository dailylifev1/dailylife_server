package com.dailylife.domain.user.entity;

import com.dailylife.domain.user.dto.UserJoinRequest;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;

    private String userPassword;

    public static User toEntity(UserJoinRequest userJoinRequest) {
        return  User.builder()

                .userName(userJoinRequest.getUserName())
                .userPassword(userJoinRequest.getUserPassword()).build();
    }

//   @Transactional


}
