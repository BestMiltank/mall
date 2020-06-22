package com.miltank.productclient.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miltank.productclient.pojo.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
