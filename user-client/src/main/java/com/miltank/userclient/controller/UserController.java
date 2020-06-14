package com.miltank.userclient.controller;

import com.miltank.userclient.pojo.User;
import com.miltank.userclient.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author shenjj
 * @date 2020-06-12 10:58
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户")
public class UserController {
    @Autowired
    private UserService userService;

//    @GetMapping("/{id}")
//    @ApiOperation(value = "查询用户详情", notes = "查询用户详情")
//    public User queryUserDetail(@PathVariable String id){
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.eq("deleted",0).eq("id",id);
//        return userService.getOne(wrapper);
//    }

    @PostMapping
    @ApiOperation(value = "注册",notes = "注册")
    public User register(@RequestBody User user){
        if(StringUtils.isNotBlank(user.getUsername()) && StringUtils.isNotBlank(user.getPassword())){
            return userService.addUser(user.getUsername(), user.getPassword());
        }
        return null;
    }
}
