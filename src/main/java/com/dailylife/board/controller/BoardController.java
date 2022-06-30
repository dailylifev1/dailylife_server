package com.dailylife.board.controller;

import com.dailylife.board.dto.BoardCreateRequest;
import com.dailylife.board.entity.Board;
import com.dailylife.board.service.BoardService;
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
@RequestMapping("api/board")
@RequiredArgsConstructor
@Api(tags = "Board API")
public class BoardController {

    private final BoardService boardService;

    @ApiOperation(value = "게시물 업로드", notes = "게시물 업로드 완료")
    @PostMapping("/create")
    public ResponseEntity<Board> createBoard(@Valid @RequestBody BoardCreateRequest boardCreateRequest){
        return ResponseEntity.ok(boardService.create(boardCreateRequest));
    }


}
