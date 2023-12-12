package com.example.demo.service;

import com.example.demo.vo.ProductResult;

import javax.servlet.http.HttpSession;

public interface ProductService {

    ProductResult searchByKey(String key, HttpSession session);
}
