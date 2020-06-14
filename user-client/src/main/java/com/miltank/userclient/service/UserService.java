package com.miltank.userclient.service;

import com.miltank.userclient.pojo.User;
import com.miltank.userclient.repository.UserRepository;
import com.miltank.userclient.util.BPwdEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shenjj
 * @date 2020-06-12 11:25
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(BPwdEncoderUtil.BCryptPassword(password));
        return userRepository.save(user);
    }
}
