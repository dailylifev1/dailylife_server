package com.dailylife.domain.reply.service;

import com.dailylife.domain.reply.dto.ReplyInsertRequest;
import com.dailylife.domain.reply.entity.Reply;
import com.dailylife.domain.user.entity.User;
import org.springframework.transaction.annotation.Transactional;

public interface ReplyService {

    Reply insert(ReplyInsertRequest replyInsertRequest);

    boolean delete(Long replyId);
}
