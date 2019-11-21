package com.board.mapper.board;

import com.board.DTO.PostDTO;
import com.board.DTO.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    public PostDTO addPost(PostDTO post) throws Exception;

    public PostDTO getPost(int id) throws Exception;

    public int updatePost(PostDTO post) throws Exception;

    //게시판 리스트
    public List<PostDTO> listAllPost() throws Exception;

    //사용자별 작성 포스트 리스트
    public List<PostDTO> listPostByUser(UserDTO user) throws Exception;

    public int deletePost(int postId) throws Exception;
}
