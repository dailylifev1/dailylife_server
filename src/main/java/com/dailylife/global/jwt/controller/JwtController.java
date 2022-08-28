package com.dailylife.global.jwt.controller;

import com.dailylife.domain.user.dto.UserJoinRequest;
import com.dailylife.domain.user.entity.User;
import com.dailylife.global.dto.ApplicationResponse;
import com.dailylife.global.jwt.service.JwtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("api/jwt")
@RequiredArgsConstructor
@Api(tags = "jwt API")
public class JwtController {

    private final JwtService jwtService;

    @ApiOperation(value = "jwt토큰갱신", notes = "jwt토큰갱신")
    @PostMapping("/update")
    public ApplicationResponse<String> saveUser() throws IOException {
        return ApplicationResponse.create("갱신된 jwt토큰" , 200 , jwtService.update(jwtService.getLoginId()));
    }


}
