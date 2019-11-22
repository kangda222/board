package com.board.service.board.manager;

import com.board.DTO.PostDTO;
import com.board.DTO.UserDTO;

import java.util.List;
import java.util.Map;

public interface PostManager {

    public int addPost(PostDTO post) throws Exception;

    public Map<String,Object> getPost(PostDTO post) throws Exception;

    public List<PostDTO> listAllPost() throws Exception;

    public List<PostDTO> listPostByUser(UserDTO user) throws Exception;
}
