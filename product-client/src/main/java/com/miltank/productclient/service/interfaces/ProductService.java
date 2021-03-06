package com.miltank.productclient.service.interfaces;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miltank.productclient.pojo.entity.Product;



public interface ProductService extends IService<Product> {
    Product queryDetailById(String id);

    void addProduct(Product product);
}
