package com.dailylife.domain.user.exception;

public class NotFoundUserException extends UserException{
    public NotFoundUserException() {
        super(500, "유저를 찾지 못했습니다.");
    }
}
