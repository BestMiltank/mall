package com.miltank.productclient.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface MyMapper<T> extends BaseMapper<T> {

    T queryOneById(String id);
}
