package com.board.DTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@Data
public class PostDTO {
    private int postId;
    private String title;
    private String content;
    private MultipartFile[] file;
    private String storedPath;
    private String fileName;
    private int userId;
    private Timestamp createdTime;
    private Timestamp updatedTime;
}
