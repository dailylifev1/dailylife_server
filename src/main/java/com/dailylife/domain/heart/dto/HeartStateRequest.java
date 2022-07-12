package com.dailylife.domain.heart.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "좋아요 상태 변경을 위한 객체")
public class HeartStateRequest {
    private Long rno;

    private Long uno;

    private Long heartState;
}
