package com.dailylife.domain.reply.controller;

import com.dailylife.domain.reply.dto.ReplyGetResponse;
import com.dailylife.domain.reply.dto.ReplyInsertRequest;
import com.dailylife.domain.reply.entity.Reply;
import com.dailylife.domain.reply.service.ReplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/reply")
@RequiredArgsConstructor
@Api(tags = "Reply API")
public class ReplyController {

    private final ReplyService replyService;

    @ApiOperation(value = "대댓글 작성", notes = "댓글(replyNum)넘겨주시면 됩니다.")
    @PostMapping("/insert")
    public ResponseEntity<Reply> createBoard(@Valid @RequestBody ReplyInsertRequest replyInsertRequest){
        return ResponseEntity.ok(replyService.insert(replyInsertRequest));
    }

    @ApiOperation(value = "대댓글 삭제", notes = "대댓글(replyNum)넘겨주시면 됩니다.")
    @DeleteMapping("/delete/{replyNum}")
    public ResponseEntity<Boolean> deleteReply(@PathVariable("replyNum")Long replyNum){
        return ResponseEntity.ok(replyService.delete(replyNum));
    }

    @ApiOperation(value = "대댓글 확인", notes = "댓글(commentNum)넘겨주시면 됩니다.")
    @GetMapping("/getReply/{commentNum}")
    public ResponseEntity<List<ReplyGetResponse>> getReply(@PathVariable("commentNum")Long commentNum){
        return ResponseEntity.ok(replyService.getReplyList(commentNum));
    }

}
