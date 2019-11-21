package com.board.service.board.manager;

import com.board.DTO.BoardDTO;
import com.board.DTO.CommentDTO;
import com.board.mapper.board.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentManagerImpl implements CommentManager,BoardCommonManager {

    @Autowired
    CommentMapper commentMapper;

    public static final String type = "comment";

    @Override
    public String getType() {
        return type;
    }

    @Override
    public BoardDTO update(BoardDTO board) throws Exception {
        CommentDTO comment = commentMapper.getComment(board.getBoardId());
        comment.setContent(board.getContent());
        comment.setUpdatedTime(board.getUpdatedTime());
        int answer = commentMapper.updateComment(comment);
        if(answer==1){
            return board;
        }else{
            return null;
        }
    }

    @Override
    public int delete(int id) throws Exception {
        return commentMapper.deleteComment(id);
    }

    @Override
    public int addComment(CommentDTO comment) throws Exception {
        //create 시간처리
        return commentMapper.addComment(comment);
    }
}
