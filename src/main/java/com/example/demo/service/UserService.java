package com.example.demo.service;

import com.example.demo.vo.LoginResult;

public interface UserService {

    LoginResult toLogin(String username, String password);
}
