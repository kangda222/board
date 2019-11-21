package com.board.DTO;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BoardDTO {
    private int boardId;
    private String title;
    private String content;
    private String type;
    private Timestamp updatedTime;
}
