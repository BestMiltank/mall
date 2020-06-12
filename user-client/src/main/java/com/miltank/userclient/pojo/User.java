package com.miltank.userclient.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @author shenjj
 * @date 2020-06-12 10:50
 */
@TableName("user")
public class User {
    private String id;
    private String account;
    private String password;

    private Date createTime;
    private Date updateTime;
    private int deleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
