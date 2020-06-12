package com.miltank.userclient.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miltank.userclient.mapper.UserMapper;
import com.miltank.userclient.pojo.User;
import com.miltank.userclient.service.interfaces.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author shenjj
 * @date 2020-06-12 11:25
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
