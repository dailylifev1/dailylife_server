package com.dailylife.domain.replyReply.service;

import com.dailylife.domain.reply.entity.Reply;
import com.dailylife.domain.reply.repository.ReplyRepository;
import com.dailylife.domain.replyReply.dto.ReplyReplyGetResponse;
import com.dailylife.domain.replyReply.dto.ReplyReplyInsertRequest;
import com.dailylife.domain.replyReply.entity.Comment;
import com.dailylife.domain.replyReply.repository.ReplyReplyRepository;
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
public class ReplyReplyServiceImpl implements ReplyReplyService {
    private final ReplyReplyRepository replyReplyRepository;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final ReplyRepository replyRepository;



    @Override
    @Transactional
    public Comment insert(ReplyReplyInsertRequest replyInsertRequest) {
        User user = userRepository.findByUserId(jwtService.getLoginId());
        Reply reply = replyRepository.findReplyByReplyNum(replyInsertRequest.getReplyNum());
        Comment reReply = replyReplyRepository.save(Comment.toEntityReplyReply(replyInsertRequest,user, reply));

        return reReply;
    }

    @Override

    public boolean delete(Long replyNum) {
        replyReplyRepository.deleteById(replyNum);
        return true;
    }

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






}
