package com.board.DTO;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserDTO {
    private int userId;
    private String email;
    private String password;
    private Timestamp createdTime;
    private Timestamp updatedTime;
}
