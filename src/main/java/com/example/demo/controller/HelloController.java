package com.example.demo.controller;
import com.example.demo.exception.MyException;
import org.springframework.web.bind.annotation.*;

// RestController 返回json
@RestController
public class HelloController {
    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }
}
