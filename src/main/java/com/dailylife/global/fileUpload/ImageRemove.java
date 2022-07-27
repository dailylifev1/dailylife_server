package com.dailylife.global.fileUpload;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ImageRemove {
    public void deleteFile(String fileName) {

        // 파일의 경로 + 파일명
        String filePath = "C:\\dailylife_server3\\src\\main\\resources\\images\\"+fileName; // 우선 절대경로 설정

        File deleteFile = new File(filePath);

        // 파일이 존재하는지 체크 존재할경우 true, 존재하지않을경우 false
        if(deleteFile.exists()) {

            // 파일을 삭제합니다.
            deleteFile.delete();

            System.out.println("파일을 삭제하였습니다.");

        } else {
            System.out.println("파일이 존재하지 않습니다.");
        }
    }
}
