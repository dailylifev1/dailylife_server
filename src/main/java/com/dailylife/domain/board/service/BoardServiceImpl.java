package com.dailylife.domain.board.service;

import com.dailylife.domain.board.dto.*;
import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.board.repository.BoardPaginationRepository;
import com.dailylife.domain.board.repository.BoardRepository;
import com.dailylife.domain.heart.service.HeartService;
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

import java.io.IOException;
import java.util.ArrayList;
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
    private final HeartService heartService;

    private static String ServerUrl = "http://146.56.39.196:8080/boardImg/";

    @Override
    @Transactional
    public BoardCreateAndGetResponse create(BoardCreateRequest boardCreateRequest) throws IOException {
        Board board = boardRepository.save(Board.toEntity(boardCreateRequest, userRepository.findByUserId(jwtService.getLoginId())));
        List<String> images = new ArrayList<>();
        List<String> ServerFileUrl = new ArrayList<>();
        if(boardCreateRequest.getImageName() != null) {
            images = multiUpload.FileUpload(boardCreateRequest.getImageName());
            for (String fileName : images) {
                ServerFileUrl.add(ServerUrl+fileName);
                imageRepository.save(Image.toEntity(fileName, board));
            }
        }
        return BoardCreateAndGetResponse.from(board , images ,ServerFileUrl,false);
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
    public List<BoardCreateAndGetResponse> getPage(BoardPagination pagination) {
        List<BoardCreateAndGetResponse> BoardCreateAndGetResponseList;
        String loginId = jwtService.getLoginId();
        User user = userRepository.findByUserId(loginId);
        Long uno = user.getUserNum();
        BoardCreateAndGetResponseList = new ArrayList<>();
        for (Board board : paginationRepository.findAll(pagination)) {
            List<String> serverFileUrl = new ArrayList<>();
            List<String> imageNameList = new ArrayList<>();
            List<Image> byBoardBoardNum = imageRepository.findByBoardBoardNum(board.getBoardNum());
            for (Image image : byBoardBoardNum) {
                imageNameList.add(image.getImageName());
                serverFileUrl.add(ServerUrl+image.getImageName());
            }
            BoardCreateAndGetResponseList.add(BoardCreateAndGetResponse.from(board , imageNameList , serverFileUrl,heartService.getHeart(uno, board.getBoardNum())));
        }
        return BoardCreateAndGetResponseList;
    }

    @Override
    public List<BoardCreateAndGetResponse> getPageNotLogin(BoardPagination pagination) {
        List<BoardCreateAndGetResponse> BoardCreateAndGetResponseList;
        BoardCreateAndGetResponseList = new ArrayList<>();
        for (Board board : paginationRepository.findAll(pagination)) {
            List<String> serverFileUrl = new ArrayList<>();
            List<String> imageNameList = new ArrayList<>();
            List<Image> byBoardBoardNum = imageRepository.findByBoardBoardNum(board.getBoardNum());
            for (Image image : byBoardBoardNum) {
                imageNameList.add(image.getImageName());
                serverFileUrl.add(ServerUrl+image.getImageName());
            }
            BoardCreateAndGetResponseList.add(BoardCreateAndGetResponse.from(board , imageNameList , serverFileUrl,false));
        }
        return BoardCreateAndGetResponseList;

    }

    @Override
    public List<BoardCreateAndGetResponse> getMyBoard(BoardPagination pagination) {
        List<BoardCreateAndGetResponse> BoardCreateAndGetResponseList;
        BoardCreateAndGetResponseList = new ArrayList<>();
        User user = userRepository.findByUserId(jwtService.getLoginId());
        Long uno = user.getUserNum();
                for (Board board : paginationRepository.findAllMyBoard(pagination , user)) {
                    List<String> serverFileUrl = new ArrayList<>();
                    List<String> imageNameList = new ArrayList<>();
                    List<Image> byBoardBoardNum = imageRepository.findByBoardBoardNum(board.getBoardNum());
                    for (Image image : byBoardBoardNum) {
                        imageNameList.add(image.getImageName());
                        serverFileUrl.add(ServerUrl+image.getImageName());
            }
            BoardCreateAndGetResponseList.add(BoardCreateAndGetResponse.from(board , imageNameList , serverFileUrl,heartService.getHeart(uno, board.getBoardNum())));
        }
        return BoardCreateAndGetResponseList;

    }


    @Override
    public int getBoardCount() {
        return boardRepository.countAllByBoardNum();
    }

    @Override
    public List<Board> TitleList(BoardPagination pagination) {
        return paginationRepository.findTitle(pagination);
    }


}
