package com.board.controller;

import com.board.DTO.UserDTO;
import com.board.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping(value = "/user/*")
public class UserRestController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public int addUser(@RequestBody UserDTO userDTO) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
        String formatTime = format.format (System.currentTimeMillis());
        Timestamp date =Timestamp.valueOf(formatTime);
        userDTO.setCreatedTime(date);
        System.out.println(userDTO);
        return userService.addUser(userDTO);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public UserDTO loginUser(@RequestBody UserDTO userDTO) throws Exception{
        return userService.loginUser(userDTO);
    }

    @RequestMapping(value = "emailDuplicationCheck", method = RequestMethod.POST)
    public boolean emailDuplicationCheck(@RequestBody UserDTO userDTO) throws Exception{
        return userService.emailDuplicationCheck(userDTO);
    }
}
