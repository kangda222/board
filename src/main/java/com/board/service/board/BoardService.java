package com.board.service.board;

import com.board.DTO.BoardDTO;
import com.board.DTO.CommentDTO;
import com.board.DTO.PostDTO;
import com.board.DTO.UserDTO;

import java.util.List;
import java.util.Map;

public interface BoardService {

    public int addPost(PostDTO postDTO) throws Exception;

    public Map<String, Object> getPost(PostDTO post) throws Exception;

    public List<PostDTO> listAllPost() throws Exception;

    public List<PostDTO> listPostByUser(UserDTO user) throws Exception;

    public int addComment(CommentDTO commentDTO) throws Exception;

    //post, comment update
    public BoardDTO update(BoardDTO board) throws Exception;

    //post, comment delete
    public int delete(int id, String type) throws Exception;

    public PostDTO downloadFile(PostDTO post) throws Exception;
}
