package com.miltank.productclient.mybatisplus;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.miltank.productclient.mybatisplus.method.QueryOneMethod;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList() {
        List<AbstractMethod> list = super.getMethodList();
        list.add(new QueryOneMethod());
        return list;
    }
}
