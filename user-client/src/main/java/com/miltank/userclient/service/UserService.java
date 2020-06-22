package com.miltank.userclient.service;

import com.miltank.userclient.client.AuthServiceClient;
import com.miltank.userclient.dto.UserLoginDTO;
import com.miltank.userclient.pojo.JWT;
import com.miltank.userclient.pojo.User;
import com.miltank.userclient.repository.UserRepository;
import com.miltank.userclient.util.BPwdEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author shenjj
 * @date 2020-06-12 11:25
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    AuthServiceClient client;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public User addUser(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(BPwdEncoderUtil.BCryptPassword(password));
        return userRepository.save(user);
    }

    public UserLoginDTO login(String username, String password) {
        User user=userRepository.findByUsername(username);
        if (null == user) {
            return null;
        }
        if(!BPwdEncoderUtil.matches(password,user.getPassword())){
            return null;
        }
        // 获取token
        JWT jwt=client.getToken("Basic dXNlci1jbGllbnQ6MTIzNDU2","password",username,password);
        // 获得用户菜单
        if(jwt==null){
            return null;
        }
        UserLoginDTO userLoginDTO=new UserLoginDTO();
        userLoginDTO.setToken(jwt.getAccess_token());
        userLoginDTO.setUser(user);
        return userLoginDTO;
    }
}
