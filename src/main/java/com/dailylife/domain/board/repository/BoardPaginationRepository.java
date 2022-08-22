package com.dailylife.domain.board.repository;

import com.dailylife.domain.board.dto.BoardPagination;
import com.dailylife.domain.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardPaginationRepository extends JpaRepository<Board, Long> {
    public default List<Board> findAll(BoardPagination pagination) {
        if(pagination.getKeyword()!=null){
            return findTitle(pagination);
        }
        Page<Board> page = this.findAll(PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
                Sort.Direction.DESC, "boardNum"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }

    Page<Board> findByTitleContaining(String keyword, Pageable pageable);

    public default List<Board> findTitle(BoardPagination pagination) {
        Page<Board> page = this.findByTitleContaining(pagination.getKeyword(),PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
                Sort.Direction.DESC, "boardNum"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }

}
