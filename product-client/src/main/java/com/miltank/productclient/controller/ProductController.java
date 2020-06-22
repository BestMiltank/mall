package com.miltank.productclient.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.miltank.productclient.pojo.entity.Product;
import com.miltank.productclient.service.interfaces.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/page")
    @ApiOperation(value = "分页查询全部信息", notes = "分页查询全部信息")
    public IPage<Product> queryProducts(Integer pageNum, Integer pageSize) {
        IPage<Product> page = new Page<>();
        page.setSize(pageSize);
        page.setCurrent(pageNum);
        return productService.page(page);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询商品", notes = "根据id查询商品")
    public Product queryOne(@PathVariable String id) {
        return productService.getById(id);
    }

    @PostMapping
    @ApiOperation(value = "上架商品", notes = "上架商品")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

}
