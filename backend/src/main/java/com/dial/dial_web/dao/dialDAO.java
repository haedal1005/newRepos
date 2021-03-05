package com.dial.dial_web.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dial.dial_web.dto.User;

import java.util.List;

@Repository
public class dialDAO {

    String ns = "dial.board.";

    @Autowired
    private SqlSession session;

    public List<User> getUser() {

        return session.selectList(ns + "getUser");
    }

    public User getUserOne(int id) {
        return session.selectOne(ns + "getUserOne", id);
    }

    public void deleteUser(int id) {
        session.delete(ns + "deleteUser", id);
    }

    public void addUser(User user) {
        session.insert(ns + "addUser", user);
    }

    public void updateUser(User user) {
        session.update(ns + "updateUser", user);
    }
}
