package com.board.service.user;

import com.board.DTO.UserDTO;

public interface UserService {

    public int addUser(UserDTO user) throws  Exception;

    public UserDTO loginUser(UserDTO user) throws Exception;

    public UserDTO updateUser(UserDTO user) throws Exception;
}
