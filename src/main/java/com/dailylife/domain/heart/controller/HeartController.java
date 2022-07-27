package com.dailylife.domain.heart.controller;

import com.dailylife.domain.heart.dto.HeartStateRequest;
import com.dailylife.domain.heart.service.HeartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/heart")
@RequiredArgsConstructor
@Api(tags = "Heart API")
public class HeartController {

    private final HeartService heartService;

    @ApiOperation(value = "댓글 좋아요", notes = "rno값(tbl_reply)PK값만 넘겨주시면 됩니다.")
    @PostMapping("/replyHeartPlus")
    public ResponseEntity<Boolean> replyHeartPlus(@Valid @RequestBody HeartStateRequest heartStateRequest){
        System.out.println("좋아요+");
        return ResponseEntity.ok(heartService.heartPlus(heartStateRequest));
    }

}
