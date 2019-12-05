package com.board.controller;

import com.board.DTO.BoardDTO;
import com.board.DTO.CommentDTO;
import com.board.DTO.PostDTO;
import com.board.DTO.UserDTO;
import com.board.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/board/*")
public class BoardRestController {

    @Autowired
    BoardService boardService;

    @Value("${uploadPath}")
    private String uploadPath;

    @RequestMapping(value = "addPost", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public int addPost(PostDTO post) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
        String formatTime = format.format (System.currentTimeMillis());
        Timestamp date =Timestamp.valueOf(formatTime);
        post.setCreatedTime(date);
        if(post.getFile().length != 0){
            String newFileName;
            if(post.getFile().length == 1){
                System.out.println(post.getFile()[0].getOriginalFilename());
                System.out.println(post.getFile()[0].getContentType());
                newFileName = post.getUserId()+"_"+post.getFile()[0].getOriginalFilename();
                post.setFileName(post.getFile()[0].getOriginalFilename());
                post.setStoredPath(uploadPath+newFileName);

                File file = new File(post.getStoredPath());
                post.getFile()[0].transferTo(file);
            }
        }
        System.out.println(post);
        return boardService.addPost(post);
        //return 0;
    }

    @RequestMapping(value = "getPost", method = RequestMethod.POST)
    public Map<String, Object> getPost(@RequestBody PostDTO post) throws Exception{
        return boardService.getPost(post);
    }

    @RequestMapping(value = "updatePost", method = RequestMethod.POST)
    public BoardDTO updatePost(@RequestBody BoardDTO board) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
        String formatTime = format.format (System.currentTimeMillis());
        Timestamp date =Timestamp.valueOf(formatTime);
        board.setUpdatedTime(date);
        System.out.println(board);
        return boardService.update(board);
    }

    @RequestMapping(value = "listAllPost", method = RequestMethod.POST)
    public List<PostDTO> listAllPost() throws Exception{
        return boardService.listAllPost();
    }

    @RequestMapping(value = "listPostByUser", method = RequestMethod.POST)
    public List<PostDTO> listPostByUser(@RequestBody UserDTO user) throws Exception{
        return boardService.listPostByUser(user);
    }

    @RequestMapping(value = "deletePost", method = RequestMethod.POST)
    public int deletePost(@RequestBody PostDTO post) throws Exception{
        return boardService.delete(post.getPostId(), "post");
    }

    @RequestMapping(value = "addComment", method = RequestMethod.POST)
    public int addComment(@RequestBody CommentDTO comment) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
        String formatTime = format.format (System.currentTimeMillis());
        Timestamp date =Timestamp.valueOf(formatTime);
        comment.setCreatedTime(date);
        System.out.println(comment);
        return boardService.addComment(comment);
    }

    @RequestMapping(value = "updateComment", method = RequestMethod.POST)
    public BoardDTO updateComment(@RequestBody BoardDTO board) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
        String formatTime = format.format (System.currentTimeMillis());
        Timestamp date =Timestamp.valueOf(formatTime);
        board.setUpdatedTime(date);
        System.out.println(board);
        return boardService.update(board);
    }

    @RequestMapping(value = "deleteComment", method = RequestMethod.POST)
    public int deleteComment(@RequestBody CommentDTO comment) throws Exception{
        return boardService.delete(comment.getCommentId(), "comment");
    }
}
