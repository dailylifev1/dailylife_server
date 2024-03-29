package com.dailylife.domain.reply.service;

import com.dailylife.domain.reply.dto.ReplyGetResponse;
import com.dailylife.domain.reply.dto.ReplyInsertRequest;
import com.dailylife.domain.reply.dto.ReplyToCommentResponse;
import com.dailylife.domain.reply.entity.Reply;

import java.util.List;

public interface ReplyService {

    Reply insert(ReplyInsertRequest replyInsertRequest);

    boolean delete(Long replyNum);

    List<ReplyGetResponse> getReplyList(Long commentNum);

    List<ReplyToCommentResponse> getReplyListToComment(Long commentNum);

}
