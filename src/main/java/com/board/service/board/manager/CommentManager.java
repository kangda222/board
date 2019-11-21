package com.board.service.board.manager;

import com.board.DTO.CommentDTO;

public interface CommentManager {

    public int addComment(CommentDTO comment) throws Exception;
}
