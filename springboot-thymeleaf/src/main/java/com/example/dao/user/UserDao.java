package com.example.dao.user;

import com.example.entity.user.User;

public interface UserDao {

    public User findByUserName(String userName);

    public void save(User user);

}
