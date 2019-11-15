package com.board.service.board;

import com.board.DTO.CommentDTO;
import com.board.DTO.PostDTO;

import java.util.List;

public interface BoardService {

    public PostDTO addPost(PostDTO postDTO) throws Exception;

    public PostDTO getPost() throws Exception;

    public List<PostDTO> getPostList() throws Exception;

    public CommentDTO addComment(CommentDTO commentDTO) throws Exception;

    //업데이트 public PostDTO updatePost(PostDTO postDTO) throws Exception;

    //삭제 post, comment
}
