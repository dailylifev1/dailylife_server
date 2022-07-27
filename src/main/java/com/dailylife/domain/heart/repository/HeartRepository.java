package com.dailylife.domain.heart.repository;

import com.dailylife.domain.heart.entity.Heart;
import com.dailylife.domain.reply.entity.Reply;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface HeartRepository extends JpaRepository<Heart, Long> {
    int countByReplyReplyNumAndUno(Long rno, Long uno);

    void deleteByReplyReplyNumAndUno(@Param(value="rno") Long rno, Long uno);
}
