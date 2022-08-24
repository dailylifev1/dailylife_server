package com.dailylife.domain.heart.controller;

import com.dailylife.domain.heart.dto.HeartStateRequest;
import com.dailylife.domain.heart.service.HeartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/heart")
@RequiredArgsConstructor
@Api(tags = "Heart API")
public class HeartController {

    private final HeartService heartService;

    @ApiOperation(value = "댓글 좋아요", notes = "replyNum값(tbl_reply)PK값만 넘겨주시면 됩니다. 한 번 누르면 좋아요 / 2번 클릭 시 좋아요 취소")
    @PostMapping("/replyHeartPlus")
    public ResponseEntity<Boolean> replyHeartPlus(@Valid @RequestBody HeartStateRequest heartStateRequest){
        return ResponseEntity.ok(heartService.heartPlusReply(heartStateRequest));
    }

    @ApiOperation(value="게시글 좋아요", notes = "boardNum값(tbl_board)PK값 넘겨주시면 됩니다. 한 번 누르면 좋아요 / 2번 클릭 시 좋아요 취소")
    @PostMapping("/boardHeartPlus")
    public ResponseEntity<Boolean> boardHeartPlus(@Valid @RequestBody HeartStateRequest heartStateRequest){
        return ResponseEntity.ok(heartService.heartPlusBoard(heartStateRequest));
    }

    @ApiOperation(value="대댓글 좋아요", notes = "replyReplyNum(tbl_replyReply)(대댓글)PK값 넘겨주시면 됩니다. 한 번 누르면 좋아요 / 2번 클릭 시 좋아요 취소")
    @PostMapping("/replyReplyHeartPlus")
    public ResponseEntity<Boolean> replyReplyHeartPlus(@Valid @RequestBody HeartStateRequest heartStateRequest){
        return ResponseEntity.ok(heartService.heartPlusReplyReply(heartStateRequest));
    }

    @ApiOperation(value = "댓글 좋아요 개수 출력", notes = "replyNum값(tbl_reply)PK값만 넘겨주시면 됩니다.")
    @GetMapping("/countHeartReply/{replyNum}")
    public ResponseEntity<Long> countHeartReply(@PathVariable("replyNum")Long replyNum){
        System.out.println("댓글 좋아요 총 개수 출력 : "+ heartService.heartCountReply(replyNum));
        return ResponseEntity.ok(heartService.heartCountReply(replyNum));

    }

    @ApiOperation(value = "게시글 좋아요 개수 출력", notes = "boardNum(tbl_board)PK값만 넘겨주시면 됩니다")
    @GetMapping("/countHeartBoard/{boardNum}")
    public ResponseEntity<Long> countHeartBoard(@PathVariable("boardNum")Long boardNum){
        System.out.println("게시물 좋아요 총 개수 출력 : "+heartService.heartCountBoard(boardNum));
        return ResponseEntity.ok(heartService.heartCountBoard(boardNum));
    }

    @ApiOperation(value = "대댓글 좋아요 개수 출력", notes = "replyNum값(tbl_reply)PK값만 넘겨주시면 됩니다.")
    @GetMapping("/countHeartReplyReply/{replyReplyNum}")
    public ResponseEntity<Long> countHeartReplyReply(@PathVariable("replyReplyNum")Long replyReplyNum){
        System.out.println("대댓글 좋아요 총 개수 출력 : "+ heartService.heartCountReplyReply(replyReplyNum));
        return ResponseEntity.ok(heartService.heartCountReplyReply(replyReplyNum));

    }
}
