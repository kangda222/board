package com.board.service.board.manager;

import com.board.DTO.BoardDTO;
import com.board.DTO.CommentDTO;
import com.board.DTO.PostDTO;
import com.board.DTO.UserDTO;
import com.board.mapper.board.CommentMapper;
import com.board.mapper.board.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostManagerImpl implements PostManager,BoardCommonManager {

    @Autowired
    PostMapper postMapper;

    @Autowired
    CommentMapper commentMapper;

    public static final String type = "post";

    @Override
    public String getType() {
        return type;
    }

    @Override
    public BoardDTO update(BoardDTO board) throws Exception {
        if(board.getTitle() == "" || board.getTitle().length() > 100){
            //error 처리 badrequest
        }
        PostDTO updatedPost = postMapper.getPost(board.getBoardId());//post return 처리

        updatedPost.setTitle(board.getTitle());
        updatedPost.setContent(board.getContent());
        updatedPost.setUpdatedTime(board.getUpdatedTime());
        int answer = postMapper.updatePost(updatedPost);
        if(answer == 1){
            board.setTitle(updatedPost.getTitle());
            board.setContent(updatedPost.getContent());
            board.setBoardId(updatedPost.getPostId());
            return board;
        }else{
            return null;
        }
    }

    @Override
    public int delete(int id) throws Exception {
        return postMapper.deletePost(id);
    }

    @Override
    public PostDTO addPost(PostDTO post) throws Exception {
        String title = post.getTitle();
        if(title == "" || title.length() > 100){
            //error 처리
            return null;
        }
        System.out.println(postMapper.addPost(post));
//        PostDTO savedPost = postMapper.addPost(post);
//        savedPost = postMapper.getPost(savedPost.getPostId());
//        return savedPost;//post return 처리
        return null;
    }

    @Override
    public Map<String,Object> getPost(PostDTO post) throws Exception {
        Map<String , Object> result = new HashMap<>();
        PostDTO postDTO = postMapper.getPost(post.getPostId());//null처리
        result.put("post", postDTO);
        List<CommentDTO> commentList = commentMapper.getCommentByPostId(post.getPostId());//null처리
        result.put("commentList", commentList);
        return result;
    }

    @Override
    public List<PostDTO> listAllPost() throws Exception {
        return postMapper.listAllPost();//null처리
    }

    @Override
    public List<PostDTO> listPostByUser(UserDTO user) throws Exception {
        return postMapper.listPostByUser(user);//null처리
    }
}
