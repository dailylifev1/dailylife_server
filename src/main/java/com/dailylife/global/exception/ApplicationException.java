package com.dailylife.global.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public abstract class ApplicationException extends RuntimeException{

    private final int errorCode;
    private String localDateTime;

    protected ApplicationException(int errorCode , String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.localDateTime = LocalDateTime.now().toString();
    }


}
