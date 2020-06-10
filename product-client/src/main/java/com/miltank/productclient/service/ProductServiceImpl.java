package com.miltank.productclient.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miltank.productclient.mapper.ProductMapper;
import com.miltank.productclient.pojo.entity.Product;
import com.miltank.productclient.service.interfaces.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
