package com.dailylife.domain.user.controller;

import com.dailylife.domain.user.dto.UserJoinRequest;
import com.dailylife.domain.user.dto.UserLoginRequest;
import com.dailylife.domain.user.dto.UserModifyRequest;
import com.dailylife.domain.user.entity.User;
import com.dailylife.domain.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
@Api(tags = "User API")
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "회원가입", notes = "회원가입을 합니다.")
    @PostMapping("/join")
    public ResponseEntity<User> saveUser(@Valid @RequestBody UserJoinRequest userJoinRequest) {
        return ResponseEntity.ok(userService.join(userJoinRequest));
    }

    @ApiOperation(value = "로그인", notes = "로그인을 합니다.")
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@Valid @RequestBody UserLoginRequest userLoginRequestRequest) {
        return ResponseEntity.ok(userService.login(userLoginRequestRequest));
    }

    @ApiOperation(value = "내 정보 수정", notes = "내 정보를 수정합니다")
    @PostMapping("/modifyUser")
    public ResponseEntity<User> modifyUser(@Valid @RequestBody UserModifyRequest userModifyRequest) {
        return ResponseEntity.ok(userService.modify(userModifyRequest));
    }
    @ApiOperation(value = "내 프로필 사진 수정", notes = "내 프로필사진을 수정합니다")
    @PostMapping("/modifyProfileImg")
    public ResponseEntity<String> modifyProfileImg(MultipartFile img) throws IOException {
        return ResponseEntity.ok(userService.modifyProfileImg(img));
    }

}
