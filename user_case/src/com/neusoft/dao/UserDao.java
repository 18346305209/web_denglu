package com.neusoft.dao;

import com.neusoft.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
}
