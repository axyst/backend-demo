package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//@RestController
// Controller 返回html
@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public String user(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("userlist", users);
        return "user";

    }


    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("host", "http://www.baidu.com");
        return"index";
    }
    @RequestMapping("/wrongpage")
    public String wrongpage() throws Exception {
        throw new Exception("发生错误");
    }
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
