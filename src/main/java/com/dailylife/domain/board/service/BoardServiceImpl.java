package com.dailylife.domain.board.service;

import com.dailylife.domain.board.dto.BoardCreateRequest;
import com.dailylife.domain.board.dto.BoardDeleteRequest;
import com.dailylife.domain.board.dto.BoardImageRequest;
import com.dailylife.domain.board.dto.BoardUpdateRequest;
import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.board.entity.Image;
import com.dailylife.domain.board.repository.BoardRepository;
import com.dailylife.domain.board.repository.ImageRepository;
import com.dailylife.domain.user.entity.User;
import com.dailylife.domain.user.repository.UserRepository;
import com.dailylife.global.jwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final JwtService jwtService;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final ImageRepository imageRepository;
    @Override
    @Transactional
    public Board create(BoardCreateRequest boardCreateRequest) {
        String id = jwtService.getLoginId();
        User user = userRepository.findByUserId(id);
        Board board = boardRepository.save(Board.toEntity(boardCreateRequest, user));
        BoardImageRequest boardImageRequest = new BoardImageRequest();
        boardImageRequest.setImgName(boardCreateRequest.getImageName()); // 게시글 등록 시 , 가져오는 사진 이름들을 추가
        Image image = imageRepository.save(Image.toEntity(boardImageRequest,board)); 
        return board;
    }

    @Override
    public boolean update(BoardUpdateRequest boardUpdateRequest) {
        Board board = boardRepository.save(Board.toEntityUpdate(boardUpdateRequest));
        return true;
    }

//    @Override
//    @Transactional
//    public boolean update2(BoardUpdateRequest boardUpdateRequest) {
//        //boradNum
//        /*
//        save -> update -> 전체를 그냥 다 업데이트 update -> null인거는 업데이트 안하고 , 값들어있는것만
//        Board board = boardRepository.findByBoardNum(Long boardNum)
//        board.set(boardUpdateRequest.get(
//         */
//
//        Board board = boardRepository.save(Board.toEntityUpdate(boardUpdateRequest));
//        return true;
//    }


    @Override
    public boolean delete(Long boardNum) {
        boardRepository.deleteById(boardNum);
        return true;
    }

}
