package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.vo.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public LoginResult toLogin(String username, String password) {
        LoginResult loginResult=new LoginResult();
        User user = userMapper.toLogin(username, password);

        if(user==null){
            loginResult.setCode(0);
            loginResult.setMsg("用户不存在");
            return loginResult;
        }

        if(!(user.getPassword().equals(password))){
            loginResult.setCode(0);
            loginResult.setMsg("密码错误");
            return loginResult;
        }

        loginResult.setUser(user);
        loginResult.setCode(1);
        loginResult.setMsg("登陆成功");
        return loginResult;
    }
}
