package com.example.dao;

import com.example.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User user);
}
