package com.dailylife.domain.replyReply.service;

import com.dailylife.domain.replyReply.dto.ReplyReplyInsertRequest;
import com.dailylife.domain.replyReply.entity.Comment;

import java.util.List;

public interface ReplyReplyService {

    Comment insert(ReplyReplyInsertRequest replyReplyInsertRequest);

    boolean delete(Long replyReplyNum);

    List<Comment> getReplyReplyList(Long replyNum);

}
