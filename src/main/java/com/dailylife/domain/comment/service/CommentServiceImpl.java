package com.dailylife.domain.comment.service;

import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.board.repository.BoardRepository;
import com.dailylife.domain.comment.dto.CommentContentResponse;
import com.dailylife.domain.comment.dto.CommentGetResponse;
import com.dailylife.domain.comment.dto.CommentInsertRequest;
import com.dailylife.domain.comment.dto.CommentReplyResponse;
import com.dailylife.domain.comment.entity.Comment;
import com.dailylife.domain.comment.repository.CommentRepository;
import com.dailylife.domain.reply.dto.ReplyGetResponse;
import com.dailylife.domain.reply.dto.ReplyToCommentResponse;
import com.dailylife.domain.reply.repository.ReplyRepository;
import com.dailylife.domain.reply.service.ReplyService;
import com.dailylife.domain.user.entity.User;
import com.dailylife.domain.user.repository.UserRepository;
import com.dailylife.global.jwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ReplyService replyService;

    private final BoardRepository boardRepository;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    @Override
    @Transactional
    public Comment insert(CommentInsertRequest commentInsertRequest) {
        Comment comment = commentRepository.save(Comment.toEntityComment(commentInsertRequest, userRepository.findByUserId(jwtService.getLoginId())));

        return comment;
    }

    @Override

    public boolean delete(Long commentNum) {
        commentRepository.deleteById(commentNum);
        return true;
    }

    @Override
    @Transactional
    public CommentGetResponse getCommentList(Long boardNum) {

        List<Comment> commentList = getCommentByBoardNum(boardNum);
        Board board = boardRepository.findBoardByBoardNum(boardNum);

        List<CommentContentResponse> commentContent =  new ArrayList<>();

        for (Comment comment : commentList) {
            commentContent.add(CommentContentResponse.from(comment.getCommentNum() , comment.getCommentContext()));

        }




        return CommentGetResponse.from(commentContent , board);

    }

    @Override
    @Transactional
    public List<CommentReplyResponse> getCommentToReply(Long boardNum) {

        List<Comment> commentList = getCommentByBoardNum(boardNum);

        List<CommentReplyResponse> commentListToReply =  new ArrayList<>();

        for (Comment comment : commentList) {

            List<ReplyToCommentResponse> replyListToComment = replyService.getReplyListToComment(comment.getCommentNum());

            commentListToReply.add(CommentReplyResponse.from(
                    comment.getCommentNum() ,
                    comment.getCommentContext() ,
                    comment.getUser().getUserName(),
                    comment.getUser().getUserProfileImg(),
                    comment.getCommentTime() ,
                    replyListToComment
            ));

        }

        return commentListToReply;
    }

    private List<Comment> getCommentByBoardNum(Long boardNum) {
        return commentRepository.findCommentByBoardNum(boardNum);
    }


}
