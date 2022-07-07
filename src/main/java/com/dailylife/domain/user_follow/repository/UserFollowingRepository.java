package com.dailylife.domain.user_follow.repository;

import com.dailylife.domain.user.entity.User;
import com.dailylife.domain.user_follow.entity.UserFollow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserFollowingRepository extends JpaRepository<UserFollow , Long> {

    Optional<List<UserFollow>> findByFollowNum(Long userNum);

}
