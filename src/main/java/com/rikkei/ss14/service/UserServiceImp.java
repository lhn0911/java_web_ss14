package com.rikkei.ss14.service;

import com.rikkei.ss14.model.User;
import com.rikkei.ss14.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public boolean create(User user) {
        return userDao.create(user);
    }
}
