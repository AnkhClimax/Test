package com.example.demo.config;

import net.minidev.json.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            //通过cookie获取用户的已登录信息
            Object user = request.getSession().getAttribute("user");
            //已登录信息不为空，说明已登录，不需要拦截

            if (user != null) {
                return true;
            }
            //需要拦截，并配置跳转登录
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            JSONObject json = new JSONObject();
            json.put("msg","ERROR");
            json.put("code", 1111);
            out.print(json);
        } catch (IOException e) {
        }
        return false;
    }
}


