package com.dailylife.domain.user_follow.controller;

import com.dailylife.domain.user_follow.dto.UserFollowingRequest;
import com.dailylife.domain.user_follow.entity.UserFollow;
import com.dailylife.domain.user_follow.service.UserFollowingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
@Api(tags = "User Following API")
public class UserFollowingController {

    private final UserFollowingService userFollowingService;

        @ApiOperation(value = "팔로우를 추가합니다.", notes = "팔로우를 추가합니다.")
        @PostMapping("/following")
        public ResponseEntity<UserFollow> following(@Valid @RequestBody UserFollowingRequest userFollowingRequest) {
            return ResponseEntity.ok(userFollowingService.following(userFollowingRequest));
        }

    @ApiOperation(value = "팔로워를 확인합니다.", notes = "팔로워를 확인합니다.")
    @PostMapping("/getFollower")
    public ResponseEntity<List<UserFollow>> getFollower() {
        return ResponseEntity.ok(userFollowingService.getFollower());
    }





}
