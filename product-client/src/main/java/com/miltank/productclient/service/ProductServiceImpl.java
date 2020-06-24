package com.miltank.productclient.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miltank.fileclient.pojo.FileInfo;
import com.miltank.productclient.feign.FileClient;
import com.miltank.productclient.mapper.ProductMapper;
import com.miltank.productclient.pojo.entity.Product;
import com.miltank.productclient.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private FileClient fileClient;

    @Override
    public Product queryDetailById(String id) {
        Product product = productMapper.selectById(id);
        product.setFiles(fileClient.queryRelationFiles(Product.class.getSimpleName(),product.getId()));
        return product;
    }

    @Override
    public void addProduct(Product product) {
        productMapper.insert(product);
        FileInfo cover = new FileInfo(product.getCover(), Product.class.getSimpleName(), product.getId(), 1);
        fileClient.addFileInfo(cover);
        List<FileInfo> files = product.getFiles();
        files = files.stream().peek(p -> {
            p.setClassName(Product.class.getSimpleName());
            p.setIsCover(0);
            p.setRelationId(product.getId());
        }).collect(Collectors.toList());
        fileClient.addFileInfo(files);
    }
}
