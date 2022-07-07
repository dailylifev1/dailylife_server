package com.dailylife.domain.board.repository;

import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.board.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
