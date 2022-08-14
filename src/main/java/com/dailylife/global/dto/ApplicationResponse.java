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
        private int httpCode;
        private T data;
        private LocalDateTime localDateTime;

    public static <T> ApplicationResponse<T> create(String message, int httpCode,
                                                    T data){
        return (ApplicationResponse<T>)
                ApplicationResponse.builder()
                .httpCode(httpCode)
                .localDateTime(LocalDateTime.now())
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ApplicationResponse<T> ok(){
        return (ApplicationResponse<T>) ApplicationResponse.builder()
                .data(null)
                .localDateTime(LocalDateTime.now())
                .message("성공")
                .build();
    }


}
