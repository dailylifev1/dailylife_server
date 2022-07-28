package com.dailylife.domain.follow.repository;

import com.dailylife.domain.follow.entity.Follow;
import com.dailylife.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowingRepository extends JpaRepository<Follow, Long> {

    Optional<List<Follow>> findByFollowNum(Long followNum);

    void deleteByFollowNum(Long followNum);

    Optional<List<Follow>> findByUser(User user);
}
