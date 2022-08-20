package com.dailylife.domain.image.service;

import com.dailylife.domain.board.dto.BoardCreateRequest;
import com.dailylife.domain.board.dto.BoardUpdateRequest;
import com.dailylife.domain.board.entity.Board;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    String saveImg(MultipartFile[] imgName) throws IOException;

    String singleSaveImg(MultipartFile imaName) throws IOException;



}
