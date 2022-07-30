package com.dailylife.domain.board.service;

import com.dailylife.domain.board.dto.BoardCreateRequest;
import com.dailylife.domain.board.dto.BoardDeleteRequest;
import com.dailylife.domain.board.dto.BoardPagination;
import com.dailylife.domain.board.dto.BoardUpdateRequest;
import com.dailylife.domain.board.entity.Board;

import java.io.IOException;
import java.util.List;

public interface BoardService {

    Board create(BoardCreateRequest boardCreateRequest) throws IOException;

    Board update(BoardCreateRequest boardCreateRequest, Long boardNum) throws IOException;

    boolean delete(Long boardNum);

    List<Board> getPage(BoardPagination pagination);

}
