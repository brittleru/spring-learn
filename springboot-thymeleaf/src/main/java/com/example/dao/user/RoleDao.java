package com.example.dao.user;

import com.example.entity.user.Role;

public interface RoleDao {

    public Role findRoleByName(String roleName);

}
