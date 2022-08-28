package com.dailylife.domain.user.controller;

import com.dailylife.domain.user.dto.UserJoinRequest;
import com.dailylife.domain.user.dto.UserLoginRequest;
import com.dailylife.domain.user.dto.UserModifyRequest;
import com.dailylife.domain.user.dto.UserPagination;
import com.dailylife.domain.user.entity.User;
import com.dailylife.domain.user.service.UserService;
import com.dailylife.global.dto.ApplicationResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/users")
@RequiredArgsConstructor
@Api(tags = "User API")
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "회원가입", notes = "회원가입을 합니다.")
    @PostMapping("/join")
    public ApplicationResponse<User> saveUser(@Valid @ModelAttribute UserJoinRequest userJoinRequest) throws IOException {
        return ApplicationResponse.create("회원가입이 완료되었습니다." , 200 , userService.join(userJoinRequest));
    }

    @ApiOperation(value = "로그인", notes = "로그인을 합니다.")
    @PostMapping("/login")
    public ApplicationResponse<User> loginUser(@Valid @RequestBody UserLoginRequest userLoginRequestRequest) {
        return ApplicationResponse.create("로그인이 완료되었습니다." , 200 , userService.login(userLoginRequestRequest));
    }

    @ApiOperation(value = "회원탈퇴" , notes = "회원을 탈퇴합니다.")
    @DeleteMapping("/quit/{userNum}")
    public ApplicationResponse<User> quitUser(@Valid @PathVariable Long userNum) {
        userService.quit(userNum);
        return ApplicationResponse.ok();
    }

    @ApiOperation(value = "내정보 보기" , notes = "내정보를 자세하게 봅니다")
    @PostMapping("/details/{userNum}")
    public ApplicationResponse<User> detailsUser(@Valid @PathVariable Long userNum) {
        return ApplicationResponse.create("유저의 대한 정보입니다" , 200 , userService.getDetails(userNum));
    }

    @ApiOperation(value = "유저찾기" , notes = "특정 유저를 찾고 그것과 유사한 name을 가진 유저를 전부 찾습니다.")
    @PostMapping("/find")
    public ApplicationResponse<List<User>> findUser(@Valid UserPagination userPagination) {
        return ApplicationResponse.create("유저에 대한 정보입니다." , 250,  userService.findUser(userPagination));
    }

    @ApiOperation(value = "userNum반환" , notes = "토큰값을 통해서 user를 찾아서 userNum을 반환")
    @PostMapping("/getUserNum")
    public ApplicationResponse<Long> getUserNum() {
        return ApplicationResponse.create("userNum을 반환합니다." , 260 , userService.getUserNum());
    }


    @PostMapping("/post")
    public String PostTest(@RequestBody String msg) {
        return "post success!!!"+msg;
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
