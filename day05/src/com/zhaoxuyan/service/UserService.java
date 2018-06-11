package com.zhaoxuyan.service;

import com.zhaoxuyan.dao.UserDao;
import com.zhaoxuyan.entity.User;

public class UserService {
    private UserDao dao = new UserDao();


    public void register(User u) throws ClassNotFoundException {
        dao.addOne(u);
    }

    public User login(String name, String pwd) throws ClassNotFoundException {
        return dao.findByNameAndPwd(name, pwd);
    }
}
