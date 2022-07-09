package com.dailylife.domain.reply.service;

import com.dailylife.domain.reply.dto.ReplyInsertRequest;
import com.dailylife.domain.reply.entity.Reply;
import com.dailylife.domain.reply.repository.ReplyRepository;
import com.dailylife.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{
    private final ReplyRepository replyRepository;



    @Override
    @Transactional
    public Reply insert(ReplyInsertRequest replyInsertRequest) {
        Reply reply = replyRepository.save(Reply.toEntityReply(replyInsertRequest));
        return reply;
    }

    @Override
    public boolean delete(Long replyId) {
        replyRepository.deleteById(replyId);
        return true;
    }


}
