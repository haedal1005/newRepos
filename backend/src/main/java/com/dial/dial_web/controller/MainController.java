package com.dial.dial_web.controller;


import com.dial.dial_web.dto.User;
import com.dial.dial_web.service.IUserService;
import com.dial.dial_web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/api")
@RestController
public class MainController {

    @Autowired
    IUserService userService;


    @RequestMapping(value = "/getTest", method = RequestMethod.GET)
    public ResponseEntity<String> getTest() throws Exception{
        System.out.println("호출됨");
        return new ResponseEntity<String>("Hello World", HttpStatus.OK);
    }

    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUser() throws Exception {

        List<User> list = new ArrayList<>();

        list = userService.getUser();

        System.out.println("찐 다이얼 게시판 호출");

        if(list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<List<User>>(list, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "board/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserOne(@PathVariable int id) throws Exception {

        User user = new User();

        user = userService.getUserOne(id);

        System.out.println("단일항목 호출띠");

        if(user.getB_id() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/board", method = RequestMethod.POST)
    public ResponseEntity<List<User>> addUser(@RequestBody User user) throws Exception {

        userService.addUser(user);

        List<User> list = new ArrayList<>();

        list = userService.getUser();

        System.out.println("앙 추가띠");

        if(list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<List<User>>(list, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/board/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<List<User>> deleteUser(@PathVariable int id) throws Exception {

        userService.deleteUser(id);

        List<User> list = new ArrayList<>();

        list = userService.getUser();

        System.out.println("앙 삭제띠");

        if(list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<List<User>>(list, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/board", method = RequestMethod.PUT)
    public ResponseEntity<List<User>> updateUser(@RequestBody User user) throws Exception {

        System.out.println(user.toString());

        userService.updateUser(user);

        List<User> list = new ArrayList<>();

        list = userService.getUser();

        if(list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<List<User>>(list, HttpStatus.OK);
        }
    }
}