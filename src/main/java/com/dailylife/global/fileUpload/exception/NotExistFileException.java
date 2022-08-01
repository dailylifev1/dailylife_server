package com.dailylife.global.fileUpload.exception;

import com.dailylife.global.exception.ApplicationException;

public class NotExistFileException extends ApplicationException {
    public NotExistFileException() {
        super(302, "파일이 존재하지 않습니다.");
    }
}
