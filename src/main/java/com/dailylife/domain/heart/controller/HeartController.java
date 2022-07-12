package com.dailylife.domain.heart.controller;

import com.dailylife.domain.heart.dto.HeartStateRequest;
import com.dailylife.domain.heart.service.HeartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/heart")
@RequiredArgsConstructor
@Api(tags = "Heart API")
public class HeartController {

    private final HeartService heartService;

    @ApiOperation(value = "댓글 좋아요", notes = "댓글 좋아요")
    @PostMapping("/replyHeart")
    public ResponseEntity<Boolean> replyHeart(@Valid @RequestBody HeartStateRequest heartStateRequest){
        System.out.println("controller");
        return ResponseEntity.ok(heartService.heartPlus(heartStateRequest));
    }
}
