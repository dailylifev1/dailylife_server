package com.dailylife.domain.comment.service;

import com.dailylife.domain.comment.dto.CommentGetResponse;
import com.dailylife.domain.comment.dto.CommentInsertRequest;
import com.dailylife.domain.comment.entity.Comment;
import com.dailylife.domain.comment.repository.CommentRepository;
import com.dailylife.domain.user.repository.UserRepository;
import com.dailylife.global.jwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    @Override
    @Transactional
    public Comment insert(CommentInsertRequest commentInsertRequest) {
        Comment comment = commentRepository.save(Comment.toEntityComment(commentInsertRequest, userRepository.findByUserId(jwtService.getLoginId())));

        return comment;
    }

    @Override

    public boolean delete(Long commentNum) {
        commentRepository.deleteById(commentNum);
        return true;
    }

    @Override
    @Transactional
    public List<CommentGetResponse> getCommentList(Long boardNum) {
        List<Comment> comment = commentRepository.findCommentByBoardNum(boardNum);
        List<CommentGetResponse> responses = new ArrayList<>();
        for (Comment list : comment) {
            list.getUser();
            responses.add(CommentGetResponse.from(list, list.getUser()));
        }
        return responses;
    }






}
