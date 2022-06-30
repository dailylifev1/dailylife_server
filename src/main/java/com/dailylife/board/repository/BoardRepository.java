package com.dailylife.board.repository;

import com.dailylife.board.entity.Board;
import com.dailylife.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
