package com.example.service.user;

import com.example.entity.user.User;
import com.example.user.CheckedUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User findByUserName(String userName);

    public void save(CheckedUser checkedUser);

}
