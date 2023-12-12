package com.example.demo.controller;

import com.example.demo.service.ProductService;
import com.example.demo.vo.ProductResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/search")
        ProductResult searchByKey(String key, HttpSession session){
        ProductResult productResult = productService.searchByKey(key, session);
        return productResult;
    }
}
