package com.neusoft.test;

import com.neusoft.dao.impl.UserDaoImpl;
import com.neusoft.domain.User;
import org.junit.Test;

import java.util.List;

public class testUserDaoImpl {
    @Test
    public void text(){
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> all = userDao.findAll();
        for(User user:all)
        {
            System.out.println(user);
        }
    }
}
