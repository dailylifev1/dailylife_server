package com.dailylife.global.exception;

import lombok.Getter;

@Getter
public abstract class ApplicationException extends RuntimeException{

    private final int errorCode;

    protected ApplicationException(int errorCode , String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }


}
