package com.board.service.board;

import com.board.DTO.BoardDTO;
import com.board.DTO.CommentDTO;
import com.board.DTO.PostDTO;
import com.board.DTO.UserDTO;
import com.board.service.board.manager.BoardCommonManager;
import com.board.service.board.manager.CommentManager;
import com.board.service.board.manager.PostManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    PostManager postManager;

    @Autowired
    CommentManager commentManager;

    @Autowired
    List<BoardCommonManager> listBoardManager;

    private static final Map<String, BoardCommonManager> serviceManagers = new HashMap<>();
    private static final String type = "post";

    @PostConstruct
    public void initServiceManager() {
        for(BoardCommonManager serviceManger : listBoardManager){
            serviceManagers.put(serviceManger.getType(), serviceManger);
        }
    }

    @Override
    public int addPost(PostDTO postDTO) throws Exception {
        return postManager.addPost(postDTO);
    }

    @Override
    public Map<String, Object> getPost(PostDTO post) throws Exception {
        Map<String, Object> postWithComments = postManager.getPost(post);
        return postWithComments;
    }

    @Override
    public List<PostDTO> listAllPost() throws Exception {
        return postManager.listAllPost();
    }

    @Override
    public List<PostDTO> listPostByUser(UserDTO user) throws Exception {
        return postManager.listPostByUser(user);
    }

    @Override
    public int addComment(CommentDTO commentDTO) throws Exception {
        return commentManager.addComment(commentDTO);
    }

    @Override
    public BoardDTO update(BoardDTO board) throws Exception {
        BoardDTO updatedBoard = serviceManagers.get(board.getType()).update(board);
        return updatedBoard;
    }

    @Override
    public int delete(int id, String type) throws Exception {
        return serviceManagers.get(type).delete(id);
    }

    @Override
    public PostDTO downloadFile(PostDTO post) throws Exception {
        return postManager.downloadFile(post.getPostId());
    }
}
