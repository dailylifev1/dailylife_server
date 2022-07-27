package com.dailylife.domain.image.repository;

import com.dailylife.domain.image.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
   void deleteByBoardBoardNum(@Param(value="boardNum") Long boardNum);

   List<Image> findByBoardBoardNum(@Param(value="boardNum") Long boardNum);
}
