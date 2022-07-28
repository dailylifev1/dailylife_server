package com.dailylife.domain.follow.service;

import com.dailylife.domain.follow.dto.FollowingRequest;
import com.dailylife.domain.follow.entity.Follow;

import java.util.List;

public interface FollowingService {
    Follow following(FollowingRequest userFollowRequest);

    List<Follow> getFollower();

    void unfollowing(FollowingRequest followingRequest);

    List<Follow> getFollow();
}
