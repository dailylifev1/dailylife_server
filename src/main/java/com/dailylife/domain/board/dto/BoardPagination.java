package com.dailylife.domain.board.dto;

import lombok.Data;

@Data
public class BoardPagination {
        int pg = 1;        // 현재 페이지
        int sz = 15;       // 페이지 당 레코드 수
        String keyword;

        int recordCount;   // 전체 레코드 수

        public String getQueryString() {
            return String.format("pg=%d&sz=%d", pg, sz);
        }
    }


