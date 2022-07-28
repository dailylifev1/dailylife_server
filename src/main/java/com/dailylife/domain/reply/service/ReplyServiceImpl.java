package com.dailylife.domain.reply.service;

import com.dailylife.domain.reply.dto.ReplyInsertRequest;
import com.dailylife.domain.reply.entity.Reply;
import com.dailylife.domain.reply.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public boolean delete(Long replyNum) {
        replyRepository.deleteById(replyNum);
        return true;
    }

    @Override
    @Transactional
    public List<Reply> getReplyList(Long boardNum) {
        List<Reply> reply = replyRepository.findByBoardNum(boardNum);
        System.out.println(replyRepository.findByBoardNum(boardNum));
        return reply;
    }






}
