package com.board.mapper.board;

import com.board.DTO.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    public int addComment(CommentDTO comment) throws Exception;

    public CommentDTO getComment(int id) throws Exception;

    public List<CommentDTO> getCommentByPostId(int id) throws Exception;

    public int updateComment(CommentDTO comment) throws Exception;

    public int deleteComment(int commentId) throws Exception;
}
