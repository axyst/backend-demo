package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@RestController
// Controller 返回html
@Controller
public class MainController {
    //@Value("letter = ${letter}")
    //private String tempvar;
    //@Autowired
    //private HelloProperties helloProperties;
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    //public String hello(@PathVariable("id") Integer id) {
//    public String hello(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
//        //return helloProperties.getTempvar();
//        //return "index";
//        return "id: " + id;
//    }
    @RequestMapping("/")
    public String index(ModelMap map) {
        //map.addAttribute("host", "http://www.baidu.com");
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
