package com.board.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class CommentDTO {
    private int commentId;
    private String content;
    private Date createdTime;
    private Date updatedTime;
}
