package com.dailylife.domain.user.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "로그인을 위한 요청 객체")
public class UserJoinRequest {

    @NotBlank(message = "아이디를 입력해주세요")
    @ApiModelProperty(notes = "아이디를 입력해주세요")
    private String userId;

    @NotBlank(message = "패스워드를 입력해주세요")
    @ApiModelProperty(notes = "패스워드를 입력해주세요")
    private String userPassword;

    @NotBlank(message = "이름을 입력해주세요")
    @ApiModelProperty(notes = "이름을 입력해주세요")
    private String userName;

    @NotBlank(message = "핸드폰 번호를 입력해주세요")
    @ApiModelProperty(notes = "핸드폰 번호를 입력해주세요")
    private String userPhoneNumber;

    @NotBlank(message = "이메일을 입력해주세요")
    @ApiModelProperty(notes = "이메일을 입력해주세요")
    private String userEmail;

    private Date userJoinDate;

    private String userProfileImg;


}
