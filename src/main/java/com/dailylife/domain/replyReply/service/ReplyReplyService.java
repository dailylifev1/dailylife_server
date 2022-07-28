package com.dailylife.domain.replyReply.service;

import com.dailylife.domain.replyReply.dto.ReplyReplyInsertRequest;
import com.dailylife.domain.replyReply.entity.ReplyReply;

import java.util.List;

public interface ReplyReplyService {

    ReplyReply insert(ReplyReplyInsertRequest replyReplyInsertRequest);

    boolean delete(Long replyReplyNum);

    List<ReplyReply> getReplyReplyList(Long replyNum);

}
