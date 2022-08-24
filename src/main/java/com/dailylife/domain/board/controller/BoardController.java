package com.dailylife.domain.board.controller;

import com.dailylife.domain.board.dto.BoardCreateRequest;
import com.dailylife.domain.board.dto.BoardCreateAndGetResponse;
import com.dailylife.domain.board.dto.BoardPagination;
import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.board.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
@Api(tags = "Board API")
public class BoardController {

    private final BoardService boardService;

    @ApiOperation(value = "게시물 업로드", notes = "게시물 업로드 완료")
    @PostMapping("/create")
    public ResponseEntity<BoardCreateAndGetResponse> createBoard(@Valid @ModelAttribute BoardCreateRequest boardCreateRequest) throws IOException {
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

    @ApiOperation(value = "페이징 게시글 가져오기 (비로그인용)", notes = "페이징 게시글 가져오기 (비로그인용)")
    @GetMapping("/getBoardNotLogin")
    public ResponseEntity<List<BoardCreateAndGetResponse>> boardList(@RequestParam(value = "pg", defaultValue = "1") int pg, @RequestParam(value = "keyword",defaultValue = "") String keyword, BoardPagination pagination) {
        return ResponseEntity.ok(boardService.getPageNotLogin(pagination));
    }

    @ApiOperation(value = "페이징 게시글 가져오기", notes = "한 페이지 당 15개 게시글 가져옴, queryString 사용하여 pg(몇 페이지)는 필수로 넘겨주시고 query(검색어)는 있으면 채워서 보내주시면 됩니다(선택)")
    @GetMapping("/getBoard")
    public ResponseEntity<List<BoardCreateAndGetResponse>> list(@RequestParam(value = "pg", defaultValue = "1") int pg, @RequestParam(value = "keyword",defaultValue = "") String keyword, BoardPagination pagination) {
        return ResponseEntity.ok(boardService.getPage(pagination));
    }

    @ApiOperation(value = "전체 게시글 수 가져오기", notes = "등록된 게시물 수 가져오기")
    @GetMapping("/getBoardCount")
    public ResponseEntity<Integer> getBoardCount() {
        return ResponseEntity.ok(boardService.getBoardCount());
    }

}
