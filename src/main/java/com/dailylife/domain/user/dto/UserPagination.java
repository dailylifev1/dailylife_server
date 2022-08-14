package com.dailylife.domain.user.dto;

import lombok.Data;

@Data
public class UserPagination {

    int pg = 1;        // 현재 페이지
    int sz = 15;       // 페이지 당 레코드 수
    String userNickName;
    int recordCount;   // 전체 레코드 수

}
