package com.dailylife.domain.board.service;

import com.dailylife.domain.board.dto.BoardCreateRequest;
import com.dailylife.domain.board.entity.Board;

public interface BoardService {

    Board create(BoardCreateRequest boardCreateRequest);
}
