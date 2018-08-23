package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
//@Controller
public class MainController {
    //@Value("letter = ${letter}")
    //private String tempvar;
    //@Autowired
    //private HelloProperties helloProperties;
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    //public String hello(@PathVariable("id") Integer id) {
    public String hello(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        //return helloProperties.getTempvar();
        //return "index";
        return "id: " + id;
    }
}
