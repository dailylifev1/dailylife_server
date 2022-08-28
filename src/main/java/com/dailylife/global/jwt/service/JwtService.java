package com.dailylife.global.jwt.service;

public interface JwtService {

    String createAccessJwt(String UserId); //생성
    String resolveAccessToken(); //검증
    String getLoginId();

    String update(String userLoginId);

}
