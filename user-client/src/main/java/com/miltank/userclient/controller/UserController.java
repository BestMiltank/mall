package com.miltank.userclient.controller;

import com.miltank.userclient.dto.UserLoginDTO;
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


    @PostMapping("/register")
    @ApiOperation(value = "注册",notes = "注册")
    public User register(@RequestBody User user){
        if(StringUtils.isNotBlank(user.getUsername()) && StringUtils.isNotBlank(user.getPassword())){
            return userService.addUser(user.getUsername(), user.getPassword());
        }
        return null;
    }

    @GetMapping("/login")
    @ApiOperation(value = "登录",notes = "登录")
    public UserLoginDTO login(@RequestParam("username") String username , @RequestParam("password") String password){
        return userService.login(username,password);
    }
}
