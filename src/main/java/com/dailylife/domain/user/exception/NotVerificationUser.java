package com.dailylife.domain.user.exception;

public class NotVerificationUser extends UserException{
    public NotVerificationUser() {
        super(501, "유저가 할 수 있는 접근이 아닙니다.");
    }
}
