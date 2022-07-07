package com.dailylife.domain.user_follow.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "팔로우 요청을 위한 객체")
public class UserFollowingRequest {

    @NotNull(message = "아이디를 입력해주세요")
    @ApiModelProperty(notes = "아이디를 입력해주세요")
    private Long followNum;

}
