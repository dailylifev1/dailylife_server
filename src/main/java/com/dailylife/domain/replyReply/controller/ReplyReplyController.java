package com.dailylife.domain.replyReply.controller;

import com.dailylife.domain.replyReply.dto.ReplyReplyGetResponse;
import com.dailylife.domain.replyReply.dto.ReplyReplyInsertRequest;
import com.dailylife.domain.replyReply.entity.Comment;
import com.dailylife.domain.replyReply.service.ReplyReplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/replyReply")
@RequiredArgsConstructor
@Api(tags = "Comment API")
public class ReplyReplyController {

    private final ReplyReplyService replyReplyService;

    @ApiOperation(value = "대댓글 작성", notes = "댓글(replyNum)넘겨주시면 됩니다.")
    @PostMapping("/insert")
    public ResponseEntity<Comment> createBoard(@Valid @RequestBody ReplyReplyInsertRequest replyReplyInsertRequest){
        return ResponseEntity.ok(replyReplyService.insert(replyReplyInsertRequest));
    }

    @ApiOperation(value = "대댓글 삭제", notes = "대댓글(replyReplyNum)넘겨주시면 됩니다.")
    @DeleteMapping("/delete/{replyReplyNum}")
    public ResponseEntity<Boolean> deleteReply(@PathVariable("replyReplyNum")Long replyReplyNum){
        return ResponseEntity.ok(replyReplyService.delete(replyReplyNum));
    }

    @ApiOperation(value = "대댓글 확인", notes = "댓글(replyNum)넘겨주시면 됩니다.")
    @GetMapping("/getReply/{replyNum}")
    public ResponseEntity<List<ReplyReplyGetResponse>> getReply(@PathVariable("replyNum")Long replyNum){
        return ResponseEntity.ok(replyReplyService.getReplyReplyList(replyNum));
    }

}
