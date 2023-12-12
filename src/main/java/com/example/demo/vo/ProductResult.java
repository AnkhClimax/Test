package com.example.demo.vo;

import lombok.Data;

import java.util.List;

@Data
public class ProductResult {

    private List<ProductVO> productVO;
    private Integer code;
    private String msg;

}
