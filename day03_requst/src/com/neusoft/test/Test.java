package com.neusoft.test;

import com.neusoft.dao.impl.UserDaoImpl;
import com.neusoft.domain.User;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {

            User loginUser = new User();
            loginUser.setUsename("sunhao");
            loginUser.setPassword("123");

            UserDaoImpl dao = new UserDaoImpl();
            User user = dao.login(loginUser);
        System.out.println(user);


    }

}
