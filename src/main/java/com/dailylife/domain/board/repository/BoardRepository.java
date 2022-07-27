package com.dailylife.domain.board.repository;

import com.dailylife.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findBoardByBoardNum(Long boardNum);

}
