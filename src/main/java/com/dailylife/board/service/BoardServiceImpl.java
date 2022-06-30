package com.dailylife.board.service;

import com.dailylife.board.dto.BoardCreateRequest;
import com.dailylife.board.entity.Board;
import com.dailylife.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    @Override
    public Board create(BoardCreateRequest boardCreateRequest) {
        Board board = boardRepository.save(Board.toEntity(boardCreateRequest));
        return board;
    }

}
