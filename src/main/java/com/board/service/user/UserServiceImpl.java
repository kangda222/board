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
        //System.out.println(validateEmail(user.getEmail()));
        if(!validateEmail(user.getEmail())){
            return 0;
        }else if(emailDuplicationCheck(user)){
            return 0;
        }
        return userMapper.addUser(user);
    }

    @Override
    public UserDTO loginUser(UserDTO user) throws Exception {
        UserDTO userDB = userMapper.getUser(user);
        if(user.getPassword().equals(userDB.getPassword())){
            return userDB;
        }else{
            return null;
        }
    }

    @Override
    public UserDTO updateUser(UserDTO user) throws Exception {
        return null;
    }

    @Override
    public UserDTO getUser(UserDTO user) throws Exception {
        return userMapper.getUser(user);
    }

    @Override
    public boolean emailDuplicationCheck(UserDTO user) throws Exception {
        if(userMapper.getUser(user) != null){
            return true;
        }else{
            return false;
        }
    }

    private boolean validateEmail(String email) throws Exception{
        return Pattern.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]+$", email);
    }

    private boolean validateUser(UserDTO user) throws Exception{
        return (user.getEmail() != null && user.getPassword() != null) ? true : false;
    }
}
