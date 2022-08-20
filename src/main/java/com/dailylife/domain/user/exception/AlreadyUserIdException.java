package com.dailylife.domain.user.exception;

public class AlreadyUserIdException extends UserException{
    public AlreadyUserIdException() {
        super(5002, "이미 존재하는 아이디 입니다.");
    }
}
