package com.example.demo.mapper;

import com.example.demo.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductVO> searchByKey(@Param("key")String key);
}
