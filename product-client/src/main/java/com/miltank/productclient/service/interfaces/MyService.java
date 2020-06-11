package com.miltank.productclient.service.interfaces;

import com.baomidou.mybatisplus.extension.service.IService;

public interface MyService<T> extends IService<T> {
    T queryOneById(String id);
}
