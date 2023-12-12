package com.example.demo.vo;

import com.example.demo.entity.User;
import lombok.Data;

@Data
public class LoginResult {

    private User user;
    private String msg;
    private Integer code;

}
