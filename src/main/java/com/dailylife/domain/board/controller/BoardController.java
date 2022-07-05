package com.dailylife.domain.board.controller;

import com.dailylife.domain.board.dto.BoardCreateRequest;
import com.dailylife.domain.board.dto.BoardUpdateRequest;
import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.board.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "게시물 수정", notes = "게시물 업로드 완료")
    @PostMapping("/update")
    public ResponseEntity<Boolean> updateBoard(@Valid @RequestBody BoardUpdateRequest boardUpdateRequest){
        return ResponseEntity.ok(boardService.update(boardUpdateRequest));
    }

    @ApiOperation(value = "게시물 삭제", notes = "게시물 삭제 완료")
    @DeleteMapping("/delete/{boardNum}")
    public ResponseEntity<Boolean> deleteBoard(@PathVariable("boardNum")Long boardNum){
        return ResponseEntity.ok(boardService.delete(boardNum));
    }


}
