package com.dailylife.domain.replyReply.service;

import com.dailylife.domain.replyReply.dto.ReplyReplyInsertRequest;
import com.dailylife.domain.replyReply.entity.ReplyReply;
import com.dailylife.domain.replyReply.repository.ReplyReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReplyReplyServiceImpl implements ReplyReplyService {
    private final ReplyReplyRepository replyReplyRepository;



    @Override
    @Transactional
    public ReplyReply insert(ReplyReplyInsertRequest replyInsertRequest) {
        ReplyReply reply = replyReplyRepository.save(ReplyReply.toEntityReplyReply(replyInsertRequest));

        return reply;
    }

    @Override

    public boolean delete(Long replyNum) {
        replyReplyRepository.deleteById(replyNum);
        return true;
    }

    @Override
    @Transactional
    public List<ReplyReply> getReplyReplyList(Long replyNum) {

        List<ReplyReply> replyReply = replyReplyRepository.findByReplyNum(replyNum);
        System.out.println(replyReplyRepository.findByReplyNum(replyNum));
        return replyReply;
    }






}
