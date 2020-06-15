package com.miltank.userclient.client.hystrix;


import com.miltank.userclient.client.AuthServiceClient;
import com.miltank.userclient.pojo.JWT;
import org.springframework.stereotype.Component;

/**
 * Created by fangzhipeng on 2017/5/31.
 */
@Component
public class AuthServiceHystrix implements AuthServiceClient {
    @Override
    public JWT getToken(String authorization, String type, String username, String password) {
        return new JWT();
    }
}
