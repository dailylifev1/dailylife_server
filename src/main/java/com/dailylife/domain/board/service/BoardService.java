package com.dailylife.domain.board.service;

import com.dailylife.domain.board.dto.*;
import com.dailylife.domain.board.entity.Board;

import java.io.IOException;
import java.util.List;

public interface BoardService {

    BoardCreateAndGetResponse create(BoardCreateRequest boardCreateRequest) throws IOException;

    Board update(BoardCreateRequest boardCreateRequest, Long boardNum) throws IOException;

    boolean delete(Long boardNum);

    List<BoardCreateAndGetResponse> getPage(BoardPagination pagination);

    int getBoardCount();

    List<Board> TitleList(BoardPagination pagination);

}
