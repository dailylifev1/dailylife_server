package com.dailylife.domain.comment.controller;

import com.dailylife.domain.comment.dto.CommentDeleteRequest;
import com.dailylife.domain.comment.dto.CommentGetResponse;
import com.dailylife.domain.comment.dto.CommentInsertRequest;
import com.dailylife.domain.comment.dto.CommentReplyResponse;
import com.dailylife.domain.comment.entity.Comment;
import com.dailylife.domain.comment.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/comment")
@RequiredArgsConstructor
@Api(tags = "Comment API")
public class CommentController {

    private final CommentService commentService;

    @ApiOperation(value = "댓글 작성", notes = "댓글 작성")
    @PostMapping("/insert")
    public ResponseEntity<Comment> createBoard(@Valid @RequestBody CommentInsertRequest commentInsertRequest){
        return ResponseEntity.ok(commentService.insert(commentInsertRequest));
    }

    @ApiOperation(value = "댓글 삭제", notes = "작성한 댓글을 삭제하기 위해서 댓글 PK (commentNum)넘겨 주시면 됩니다.")
    @DeleteMapping("/delete/{commentNum}")
    public ResponseEntity<Boolean> deleteReply(@PathVariable("commentNum")Long commentNum, CommentDeleteRequest commentDeleteRequest){
        return ResponseEntity.ok(commentService.delete(commentNum));
    }

    @ApiOperation(value = "댓글 확인", notes = "게시물 댓글 확인을 위해서 게시물번호 PK (boardNum)넘겨 주시면 됩니다.")
    @GetMapping("/getComment/{boardNum}")
    public ResponseEntity<CommentGetResponse> getComment(@PathVariable("boardNum")Long boardNum){
        return ResponseEntity.ok(commentService.getCommentList(boardNum));
    }

    @ApiOperation(value = "전체 댓글과 대댓글 리스트 확인", notes = "boardNum을 넘겨주시면 됩니다.")
    @GetMapping("/getCommentToReply/{boardNum}")
    public ResponseEntity<List<CommentReplyResponse>> getCommentToReply(@PathVariable("boardNum")Long boardNum){
        return ResponseEntity.ok(commentService.getCommentToReply(boardNum));
    }




}
