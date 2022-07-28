package com.dailylife.global.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super("찾을수 없습니다.");
    }

}
