package com.dailylife.domain.board.repository;

import com.dailylife.domain.board.dto.BoardDeleteRequest;
import com.dailylife.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
