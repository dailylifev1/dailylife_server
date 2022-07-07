package com.dailylife.domain.user_follow.entity;

import com.dailylife.domain.user.entity.User;
import com.dailylife.domain.user_follow.dto.UserFollowingRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity(name = "tbl_user_follow")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFollow {

    //1 - > 3 팔로우
    //3 을 팔로우한 1번

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userFollowNum;

    private Long followNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_num")
    @JsonIgnore
    private User user;

    public void setUser(User user) {
        this.user = user;
        user.getUserFollows().add(this);
    }

    public static UserFollow toEntity(UserFollowingRequest userFollowRequest , User user) {
        UserFollow userFollow = UserFollow.builder()
                .followNum(userFollowRequest.getFollowNum())
                .build();
        userFollow.setUser(user);
        return userFollow;
    }

}
