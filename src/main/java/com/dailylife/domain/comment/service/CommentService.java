package com.dailylife.domain.comment.service;

import com.dailylife.domain.comment.dto.CommentGetResponse;
import com.dailylife.domain.comment.dto.CommentInsertRequest;
import com.dailylife.domain.comment.entity.Comment;

import java.util.List;

public interface CommentService {

    Comment insert(CommentInsertRequest commentInsertRequest);

    boolean delete(Long commentNum);

   CommentGetResponse getCommentList(Long boardNum);

}
