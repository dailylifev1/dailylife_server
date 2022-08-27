package com.dailylife.domain.reply.service;

import com.dailylife.domain.reply.dto.ReplyGetResponse;
import com.dailylife.domain.reply.dto.ReplyInsertRequest;
import com.dailylife.domain.reply.entity.Reply;
import com.dailylife.domain.reply.repository.ReplyRepository;
import com.dailylife.domain.user.repository.UserRepository;
import com.dailylife.global.jwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{
    private final ReplyRepository replyRepository;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    @Override
    @Transactional
    public Reply insert(ReplyInsertRequest replyInsertRequest) {
        Reply reply = replyRepository.save(Reply.toEntityReply(replyInsertRequest, userRepository.findByUserId(jwtService.getLoginId())));

        return reply;
    }

    @Override

    public boolean delete(Long replyNum) {
        replyRepository.deleteById(replyNum);
        return true;
    }

    @Override
    @Transactional
    public List<ReplyGetResponse> getReplyList(Long boardNum) {
        List<Reply> reply = replyRepository.findReplyByBoardNum(boardNum);
        List<ReplyGetResponse> responses = new ArrayList<>();
        for (Reply list : reply) {
            list.getUser();
            responses.add(ReplyGetResponse.from(list, list.getUser()));
        }
        return responses;
    }






}
