package com.dailylife.global.fileUpload;

import com.dailylife.global.fileUpload.exception.NotFoundFileException;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ImageRemove {
    public void deleteFile(String fileName) {

        // 파일의 경로 + 파일명
//        String filePath = "C:\\dailylife_server3\\src\\main\\resources\\images\\"+fileName; // 우선 절대경로 설정
        String filePath = "/home/ubuntu/images/"+fileName; //
        File deleteFile = new File(filePath);

        if(deleteFile.exists()) {
            deleteFile.delete();
            throw new NotFoundFileException();
        } else {
            throw new NotFoundFileException();
        }
    }
}
