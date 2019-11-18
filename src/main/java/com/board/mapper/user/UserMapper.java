package com.board.mapper.user;

import com.board.DTO.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public int addUser (UserDTO user);

    public UserDTO getUser(UserDTO user);

}
