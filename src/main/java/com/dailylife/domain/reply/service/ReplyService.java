package com.dailylife.domain.reply.service;

import com.dailylife.domain.reply.dto.ReplyInsertRequest;
import com.dailylife.domain.reply.entity.Reply;

import java.util.List;
import java.util.Optional;

public interface ReplyService {

    Reply insert(ReplyInsertRequest replyInsertRequest);

    boolean delete(Long replyNum);

    List<Reply> getReplyList(Long boardNum);

}
