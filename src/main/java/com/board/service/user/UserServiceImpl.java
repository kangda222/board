package com.board.service.user;

import com.board.DTO.UserDTO;
import com.board.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int addUser(UserDTO user) throws Exception {
        System.out.println(user.getEmail());
        System.out.println(validateEmail(user.getEmail()));
        //return userMapper.addUser(user);
        return 0;
    }

    @Override
    public UserDTO loginUser(UserDTO user) throws Exception {
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO user) throws Exception {
        return null;
    }

    private boolean validateEmail(String email) throws Exception{
        return Pattern.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+$", email);
    }
}
