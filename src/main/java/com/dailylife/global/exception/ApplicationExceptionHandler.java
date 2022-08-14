package com.dailylife.global.exception;

import com.dailylife.global.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> globalRuntimeException(ApplicationException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode(), e.getMessage() , e.getLocalDateTime());
        return ResponseEntity.ok(errorResponse);
    }








}
