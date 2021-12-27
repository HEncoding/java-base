package com.powernode.service;

import com.powernode.mapper.LoginDao;
import com.powernode.model.User;

/**
 * @Author : HD
 * @create 2021/12/7 21:19
 */
public class LoginService {
    private LoginDao loginDao = new LoginDao();

    public User  login(User user) {
        return loginDao.login(user);
    }
}
