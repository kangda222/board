package com.board.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class UserDTO {

    private int userId;
    private String email;
    private String password;
    private Date createdTime;
    private Date updatedTime;
}
