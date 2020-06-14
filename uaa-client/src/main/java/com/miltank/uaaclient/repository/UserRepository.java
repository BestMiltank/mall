package com.miltank.uaaclient.repository;

import com.miltank.uaaclient.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
