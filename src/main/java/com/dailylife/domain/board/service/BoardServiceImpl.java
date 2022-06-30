package com.dailylife.domain.board.service;

import com.dailylife.domain.board.dto.BoardCreateRequest;
import com.dailylife.domain.board.dto.BoardDeleteRequest;
import com.dailylife.domain.board.dto.BoardUpdateRequest;
import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.board.repository.BoardRepository;
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

    @Override
    public boolean update(BoardUpdateRequest boardUpdateRequest) {
        Board board = boardRepository.save(Board.toEntityUpdate(boardUpdateRequest));

        return true;
    }

    @Override
    public boolean delete(Long boardNum) {
        boardRepository.deleteById(boardNum);

        return true;
    }

}
