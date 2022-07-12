package com.dailylife.domain.heart.repository;

import com.dailylife.domain.heart.entity.Heart;
import com.dailylife.domain.reply.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeartRepository extends JpaRepository<Heart, Long> {

}
