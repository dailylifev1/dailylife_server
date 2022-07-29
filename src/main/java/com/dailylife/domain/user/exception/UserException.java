package com.dailylife.domain.user.exception;

import com.dailylife.global.exception.ApplicationException;

public abstract class UserException extends ApplicationException {
    protected UserException(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
