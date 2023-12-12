package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.vo.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public LoginResult toLogin(String username, String password, HttpSession session){
        LoginResult loginResult = userService.toLogin(username, password);
        if(loginResult.getCode().equals(0)){
            return loginResult;
        }else if(loginResult.getCode().equals(1)){
            session.setAttribute("user",loginResult.getUser());
        }
        return loginResult;
    }
}
