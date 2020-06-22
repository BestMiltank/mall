package com.miltank.userclient.dto;

import com.miltank.userclient.pojo.User;

/**
 * Created by fangzhipeng on 2017/5/27.
 */
public class UserLoginDTO {

    private String token;

    private User user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
