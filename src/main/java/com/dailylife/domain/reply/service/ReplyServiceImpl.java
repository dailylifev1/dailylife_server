package com.dailylife.domain.reply.service;

import com.dailylife.domain.comment.entity.Comment;
import com.dailylife.domain.comment.repository.CommentRepository;
import com.dailylife.domain.reply.dto.ReplyGetResponse;
import com.dailylife.domain.reply.dto.ReplyInsertRequest;
import com.dailylife.domain.reply.entity.Reply;
import com.dailylife.domain.reply.repository.ReplyRepository;
import com.dailylife.domain.user.entity.User;
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
public class ReplyServiceImpl implements ReplyService {
    private final ReplyRepository replyRepository;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;



    @Override
    @Transactional
    public Reply insert(ReplyInsertRequest replyInsertRequest) {
        User user = userRepository.findByUserId(jwtService.getLoginId());
        Comment comment = commentRepository.findCommentByCommentNum(replyInsertRequest.getCommentNum());
        Reply reply = replyRepository.save(Reply.toEntityReply(replyInsertRequest,user,comment));






        return reply;
    }

    @Override

    public boolean delete(Long replyNum) {
        replyRepository.deleteById(replyNum);
        return true;
    }


    @Override
    @Transactional
    public List<ReplyGetResponse> getReplyList(Long commentNum) {
        List<ReplyGetResponse> response = new ArrayList<>();
        List<Reply> reply = replyRepository.findByReplyNum(commentNum);
        for (Reply list : reply) {
            list.getUser();
            response.add(ReplyGetResponse.from(list,list.getUser(),list.getComment()));
        }
        return response;
    }



/*
    @Override
    @Transactional
    public List<ReplyReplyGetResponse> getReplyReplyList(Long replyNum) {
        List<ReplyReplyGetResponse> response = new ArrayList<>();
        List<Comment> comment = replyReplyRepository.findByReplyNum(replyNum);
        for (Comment list : comment) {
            response.add(ReplyReplyGetResponse.from(list,list.getUser()));

        }

        return response;
    }






}*/


}
