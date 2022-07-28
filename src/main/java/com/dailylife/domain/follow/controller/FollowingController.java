package com.dailylife.domain.follow.controller;

import com.dailylife.domain.follow.dto.FollowingRequest;
import com.dailylife.domain.follow.entity.Follow;
import com.dailylife.domain.follow.service.FollowingService;
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
@Api(tags = "Following API")
public class FollowingController {

    private final FollowingService followingService;

        @ApiOperation(value = "팔로우를 추가합니다.", notes = "팔로우를 추가합니다.")
        @PostMapping("/following")
        public ResponseEntity<Follow> following(@Valid @RequestBody FollowingRequest followingRequest) {
            return ResponseEntity.ok(followingService.following(followingRequest));
        }

    @ApiOperation(value = "팔로우를 해제합니다.", notes = "팔로우를 해제합니다.")
    @PostMapping("/unfollowing")
    public ResponseEntity<String> unfollowing(@Valid @RequestBody FollowingRequest followingRequest) {
        followingService.unfollowing(followingRequest);
        return ResponseEntity.ok("확인");
    }

    @ApiOperation(value = "팔로워를 확인합니다.", notes = "팔로워를 확인합니다.")
    @PostMapping("/getFollower")
    public ResponseEntity<List<Follow>> getFollower() {
        return ResponseEntity.ok(followingService.getFollower());
    }

    @ApiOperation(value = "팔로우를 확인합니다", notes = "팔로우를 확인합니다.")
    @PostMapping("/getFollow")
    public String getFollow() {
        followingService.getFollow();
            return null;
    }

}
