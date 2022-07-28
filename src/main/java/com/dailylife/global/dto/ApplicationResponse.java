package com.dailylife.global.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ApplicationResponse<T> {

        private String message;
        private boolean success;
        private int httpCode;
        private HttpStatus httpStatus;
        private T data;
        private LocalDateTime localDateTime;

    public static <T> ApplicationResponse<T> create(String message, HttpStatus httpStatus,
                                                    T data){
        return (ApplicationResponse<T>)
                ApplicationResponse.builder()
                .httpCode(httpStatus.value())
                .localDateTime(LocalDateTime.now())
                .message(message)
                .httpStatus(httpStatus)
                .data(data)
                .success(true)
                .build();
    }

    public static <T> ApplicationResponse<T> ok(){
        return (ApplicationResponse<T>) ApplicationResponse.builder()
                .data(null)
                .success(true)
                .localDateTime(LocalDateTime.now())
                .message("성공")
                .httpStatus(HttpStatus.OK)
                .build();
    }


}
