package com.dailylife.domain.image.service;

import com.dailylife.domain.board.dto.BoardCreateRequest;
import com.dailylife.domain.board.dto.BoardUpdateRequest;
import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.board.repository.BoardRepository;
import com.dailylife.domain.image.dto.BoardImageRequest;
import com.dailylife.domain.image.entity.Image;
import com.dailylife.domain.image.repository.ImageRepository;
import com.dailylife.domain.user.entity.User;
import com.dailylife.domain.user.repository.UserRepository;
import com.dailylife.global.fileUpload.MultiUpload;
import com.dailylife.global.fileUpload.SingleUpload;
import com.dailylife.global.jwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final ImageRepository imageRepository;
    private final MultiUpload multiUpload;
    private final SingleUpload singleUpload;
    @Override
    public String saveImg(MultipartFile[] imgName) throws IOException{
        List<String> images = multiUpload.FileUpload(imgName);
        System.out.println(images);
        return null;
    }

    @Override
    public String singleSaveImg(MultipartFile imaName) throws IOException {
        return singleUpload.FileUpload(imaName);
    }

}
