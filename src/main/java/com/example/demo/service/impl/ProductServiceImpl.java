package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.service.ProductService;
import com.example.demo.vo.ProductResult;
import com.example.demo.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public ProductResult searchByKey(String key, HttpSession session) {
        ProductResult productResult=new ProductResult();
        productResult.setCode(1);
        productResult.setMsg("搜索成功");

        List<ProductVO> list = productMapper.searchByKey(key);

        if(list==null){
            productResult.setCode(0);
            productResult.setMsg("无结果");
            return productResult;
        }

        User user = (User) session.getAttribute("user");

        if(user.getVip().equals(0)){
            list.forEach(productVO -> productVO.setT_content4("请开通vip查看"));
            list.forEach(productVO -> productVO.setT_content5("请开通vip查看"));
            productResult.setProductVO(list);
            return productResult;
        }
        if(user.getVip().equals(1)){
            productResult.setProductVO(list);
        }
        return productResult;
    }
}
