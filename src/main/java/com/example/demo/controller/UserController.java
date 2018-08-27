package com.example.demo.controller;

import com.example.demo.aspect.HttpAspect;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.domain.User;

import java.util.*;


@RestController
@RequestMapping(value = "/user")     // 下面的映射都在/users下
public class UserController {
    @Autowired
    private UserService userService;
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getList() {
        return userService.findAll();
    }

    @RequestMapping(value = "/{username}/find", method = RequestMethod.GET)
    public List<User> findUser(@PathVariable String username) {
        return userService.findByName(username);
    }

    @RequestMapping(value = "/{username}/{age}/insert", method = RequestMethod.GET)
    public void insertUser(@PathVariable String username, @PathVariable int age) {
        userService.insertUser(username, age);
    }

    @RequestMapping(value = "/{userid}/remove", method = RequestMethod.GET)
    public void deleteUser(@PathVariable Long userid) {
        userService.deleteUser(userid);
    }

    @RequestMapping(value = "/{userid}/modify/{username}/{age}", method = RequestMethod.GET)
    public void modifyUser(@PathVariable Long userid, @PathVariable String username, @PathVariable Integer age) {
        userService.updateUser(userid, username, age);
    }


}