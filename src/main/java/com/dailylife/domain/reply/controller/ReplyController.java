package com.dailylife.domain.reply.controller;

import com.dailylife.domain.board.dto.BoardCreateRequest;
import com.dailylife.domain.board.dto.BoardUpdateRequest;
import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.board.service.BoardService;
import com.dailylife.domain.reply.dto.ReplyDeleteRequest;
import com.dailylife.domain.reply.dto.ReplyInsertRequest;
import com.dailylife.domain.reply.entity.Reply;
import com.dailylife.domain.reply.service.ReplyService;
import com.dailylife.domain.user.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/reply")
@RequiredArgsConstructor
@Api(tags = "Reply API")
public class ReplyController {

    private final ReplyService replyService;

    @ApiOperation(value = "댓글 작성", notes = "댓글 작성")
    @PostMapping("/insert")
    public ResponseEntity<Reply> createBoard(@Valid @RequestBody ReplyInsertRequest replyInsertRequest){
        return ResponseEntity.ok(replyService.insert(replyInsertRequest));
    }

    @ApiOperation(value = "게시물 삭제", notes = "게시물 삭제 완료")
    @DeleteMapping("/delete/{replyId}")
    public ResponseEntity<Boolean> deleteReply(@PathVariable("replyId")Long replyId, ReplyDeleteRequest replyDeleteRequest){
        return ResponseEntity.ok(replyService.delete(replyId));
    }

}
