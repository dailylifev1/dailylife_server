package com.dailylife.domain.board.service;

import com.dailylife.domain.board.dto.FileUploadRequest;
import com.dailylife.domain.board.entity.File;
import com.dailylife.domain.board.repository.FileRepository;

public class FileServiceImpl implements FileService{
//슬랙테스트
    private final FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }


    @Override
    public boolean upload(String originFileName) {
        return false;
    }
}
