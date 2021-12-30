package com.example.service;

import com.example.entity.User;
import com.example.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);
    void save(CrmUser crmUser);
}
