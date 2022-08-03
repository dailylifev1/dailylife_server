package com.dailylife.domain.board.controller;

import com.dailylife.domain.board.dto.BoardCreateRequest;
import com.dailylife.domain.board.dto.BoardCreateResponse;
import com.dailylife.domain.board.dto.BoardPagination;
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
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
@Api(tags = "Board API")
public class BoardController {

    private final BoardService boardService;

    @ApiOperation(value = "게시물 업로드", notes = "게시물 업로드 완료")
    @PostMapping("/create")
    public ResponseEntity<BoardCreateResponse> createBoard(@Valid @ModelAttribute BoardCreateRequest boardCreateRequest) throws IOException {
        return ResponseEntity.ok(boardService.create(boardCreateRequest));
    }

    @ApiOperation(value = "게시물 수정", notes = "게시물 수정 url에 boardNum 같이 넘겨주세요// 현재 게시글 수정 시 기존 사진 삭제 후 새로 등록한 사진이 업로드 ")
    @PostMapping("/update/{boardNum}")
    public ResponseEntity<Board> updateBoard(@PathVariable("boardNum") Long boardNum,@Valid @ModelAttribute BoardCreateRequest boardCreateRequest) throws IOException {
        return ResponseEntity.ok(boardService.update(boardCreateRequest, boardNum));
    }

    @ApiOperation(value = "게시물 삭제", notes = "게시물 삭제 완료")
    @DeleteMapping("/delete/{boardNum}")
    public ResponseEntity<Boolean> deleteBoard(@PathVariable("boardNum")Long boardNum){

        return ResponseEntity.ok(boardService.delete(boardNum));
    }
    @ApiOperation(value = "페이징 게시글 가져오기", notes = "한 페이지 당 15개 게시글 가져옴, pg(현재 페이지)만 넘겨주시면 됩니다")
    @GetMapping("/getBoard/{pg}")
    public ResponseEntity<List<Board>> list(@PathVariable("pg")int pg, BoardPagination pagination) {
        return ResponseEntity.ok(boardService.getPage(pagination));
    }



}
