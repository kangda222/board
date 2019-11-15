package com.board.service.user;

import com.board.DTO.UserDTO;

public interface UserService {

    public UserDTO addUser(UserDTO user) throws  Exception;

    public UserDTO loginUser(UserDTO user) throws Exception;

    public UserDTO updateUser(UserDTO user) throws Exception;
}
