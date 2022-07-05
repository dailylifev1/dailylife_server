package com.dailylife.domain.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "로그인을 위한 요청 객체")
public class UserLoginRequest {

    @NotBlank(message = "아이디를 입력해주세요")
    @ApiModelProperty(notes = "아이디를 입력해주세요")
    private String userId;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @ApiModelProperty(notes = "비밀번호를 입력해주세요")
    private String userPassword;






}
