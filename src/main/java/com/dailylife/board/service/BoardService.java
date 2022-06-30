package com.dailylife.board.service;

import com.dailylife.board.dto.BoardCreateRequest;
import com.dailylife.board.entity.Board;

public interface BoardService {

    Board create(BoardCreateRequest boardCreateRequest);
}
