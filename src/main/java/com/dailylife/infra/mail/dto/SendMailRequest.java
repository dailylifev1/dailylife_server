package com.dailylife.infra.mail.dto;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.Pattern;

@Data
public class SendMailRequest {

    @Pattern(regexp = "^[a-zA-z0-9._%+-]+@[a-zA-z0-9.-]+\\.[a-zA-z]{2,6}$",message = "이메일 양식을 확인해주세요")
    private String email;

}
