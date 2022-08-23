package com.dailylife.domain.replyReply.service;

import com.dailylife.domain.replyReply.dto.ReplyReplyInsertRequest;
import com.dailylife.domain.replyReply.entity.Comment;
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
    public Comment insert(ReplyReplyInsertRequest replyInsertRequest) {
        Comment reply = replyReplyRepository.save(Comment.toEntityReplyReply(replyInsertRequest));

        return reply;
    }

    @Override

    public boolean delete(Long replyNum) {
        replyReplyRepository.deleteById(replyNum);
        return true;
    }

    @Override
    @Transactional
    public List<Comment> getReplyReplyList(Long replyNum) {

        List<Comment> comment = replyReplyRepository.findByReplyNum(replyNum);
        System.out.println(replyReplyRepository.findByReplyNum(replyNum));
        return comment;
    }






}
