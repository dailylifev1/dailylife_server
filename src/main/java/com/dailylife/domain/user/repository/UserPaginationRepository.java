package com.dailylife.domain.user.repository;

import com.dailylife.domain.board.dto.BoardPagination;
import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.user.dto.UserPagination;
import com.dailylife.domain.user.entity.User;
import com.dailylife.domain.user.exception.NotFoundUserException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPaginationRepository extends JpaRepository<User, Long> {

    public default List<User> findAll(UserPagination pagination) {
        if(pagination.getUserNickName()!=null){
            return findUserName(pagination);
        }
        throw new NotFoundUserException();
    }

    Page<User> findByUserNameContaining(String keyword, Pageable pageable);

    public default List<User> findUserName(UserPagination pagination) {
        Page<User> page = this.findByUserNameContaining(pagination.getUserNickName(),PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
                Sort.Direction.DESC, "userNum"));
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }

}
