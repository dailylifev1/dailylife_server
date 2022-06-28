package com.dailylife.domain.user.repository;

import com.dailylife.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    int countByUserName(String userName);
}
