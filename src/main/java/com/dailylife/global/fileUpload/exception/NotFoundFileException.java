package com.dailylife.global.fileUpload.exception;

import com.dailylife.global.exception.ApplicationException;

public class NotFoundFileException extends ApplicationException {

    public NotFoundFileException() {
        super(301, "파일을 찾을수 없습니다.");
    }
}
