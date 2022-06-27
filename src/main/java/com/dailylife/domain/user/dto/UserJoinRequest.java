package com.dailylife.domain.user.dto;

import io.swagger.annotations.Api;
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
public class UserJoinRequest {

    @NotBlank(message = "유저네임을 입력해주세요")
    @ApiModelProperty(notes = "유저네임을 입력해주세요")
    private String userName;

    @NotBlank(message = "유저의 패스워드를 입력해주세요")
    @ApiModelProperty(notes = "유저의 패스워드를 입력해주세요")
    private String userPassword;








}
