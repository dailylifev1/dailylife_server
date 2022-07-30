package com.dailylife.domain.board.service;

import com.dailylife.domain.board.dto.BoardCreateRequest;
import com.dailylife.domain.board.dto.BoardDeleteRequest;
import com.dailylife.domain.board.dto.BoardPagination;
import com.dailylife.domain.board.dto.BoardUpdateRequest;
import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.board.repository.BoardPaginationRepository;
import com.dailylife.domain.board.repository.BoardRepository;
import com.dailylife.domain.image.dto.BoardImageRequest;
import com.dailylife.domain.image.entity.Image;
import com.dailylife.domain.image.repository.ImageRepository;
import com.dailylife.domain.user.entity.User;
import com.dailylife.domain.user.repository.UserRepository;
import com.dailylife.global.fileUpload.ImageRemove;
import com.dailylife.global.fileUpload.MultiUpload;
import com.dailylife.global.jwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final JwtService jwtService;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final ImageRepository imageRepository;
    private final MultiUpload multiUpload;
    private final ImageRemove imageRemove;

    private final BoardPaginationRepository paginationRepository;

    @Override
    @Transactional
    public Board create(BoardCreateRequest boardCreateRequest) throws IOException {
        Board board = boardRepository.save(Board.toEntity(boardCreateRequest, userRepository.findByUserId(jwtService.getLoginId())));
        if(boardCreateRequest.getImageName() != null) {
        List<String> images = multiUpload.FileUpload(boardCreateRequest.getImageName());
            for (String fileName : images) {
                imageRepository.save(Image.toEntity(fileName, board));
            }
        }
        return board;
    }

    @Override
    @Transactional
    public Board update(BoardCreateRequest boardCreateRequest, Long boardNum) throws IOException{
        Board board = boardRepository.findBoardByBoardNum(boardNum);
        List<Image> image = imageRepository.findByBoardBoardNum(boardNum);
        for(int i =0; i<image.size(); i++) {
            imageRemove.deleteFile(image.get(i).getImageName()); // 기존에 존재하던 이미지 파일 삭제
        }
        board.setTitle(boardCreateRequest.getTitle());
        board.setContent(boardCreateRequest.getContent());
        board.setThumbNail(boardCreateRequest.getThumbNail());
        if(boardCreateRequest.getImageName() != null) {
        List<String> images = multiUpload.FileUpload(boardCreateRequest.getImageName());
            for (String fileName : images) {
                imageRepository.save(Image.toEntity(fileName, board));
            }
        }
        return board;
    }

    @Override
    public boolean delete(Long boardNum) {
        boardRepository.deleteById(boardNum);
        return true;
    }

    @Override
    public List<Board> getPage(BoardPagination pagination) {
        return paginationRepository.findAll(pagination);
    }
}
