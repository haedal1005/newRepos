package com.dial.dial_web.service;

import com.dial.dial_web.dto.User;

import java.util.List;

public interface IUserService {

    List<User> getUser();

    User getUserOne(int id);

    void deleteUser(int id);

    void addUser(User user);

    void updateUser(User user);
}
