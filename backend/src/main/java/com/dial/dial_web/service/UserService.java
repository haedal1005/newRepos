package com.dial.dial_web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dial.dial_web.dto.User;
import com.dial.dial_web.dao.dialDAO;


import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private dialDAO dao;

    @Override
    public List<User> getUser() {
        return dao.getUser();
    }

    @Override
    public User getUserOne(int id) {
        return dao.getUserOne(id);
    }

    @Override
    public void deleteUser(int id) {
        dao.deleteUser(id);
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }
}
