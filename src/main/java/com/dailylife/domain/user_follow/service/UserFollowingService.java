package com.dailylife.domain.user_follow.service;

import com.dailylife.domain.user_follow.dto.UserFollowingRequest;
import com.dailylife.domain.user_follow.entity.UserFollow;

import java.util.List;

public interface UserFollowingService {
    UserFollow following(UserFollowingRequest userFollowRequest);

    List<UserFollow> getFollower();
}
