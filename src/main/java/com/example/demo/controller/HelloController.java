package com.example.demo.controller;

import com.example.demo.domain.Hello;
import com.example.demo.domain.Result;
import com.example.demo.repository.HelloRepository;
import com.example.demo.service.HelloService;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

// database controll
@RestController
public class HelloController {

    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloRepository helloRepository;

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/hellos")
    public List<Hello> helloList() {
        logger.info("helloList");
        return helloRepository.findAll();
    }

    @PostMapping(value = "/hellos")
    public Result<Hello> helloAdd(@Valid Hello hello, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return null;
            //return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(helloRepository.save(hello));
    }

    @GetMapping(value = "/hellos/{id}")
    public Optional<Hello> helloFindOne(@PathVariable("id") Integer id) {
        //直接用findById查找
        return helloRepository.findById(id);
        //构通Example查找
//        Hello hello = new Hello();
//        hello.setId(id);
//        Example<Hello> example = Example.of(hello);
//        return helloRepository.findOne(example);
    }

    @PutMapping(value = "/hellos/{id}")
    public Hello helloUpdate(@PathVariable("id") Integer id, @RequestParam("tempvar") String tempvar,
                             @RequestParam("age") Integer age) {
        Hello hello = new Hello();
        hello.setId(id);
        hello.setTempvar(tempvar);
        hello.setAge(age);
        return helloRepository.save(hello);
    }

    @DeleteMapping(value = "/hellos/{id}")
    public void helloDelete(@PathVariable("id") Integer id) {
        helloRepository.deleteById(id);
    }

    // select by tempvar
    @GetMapping(value = "/hellos/tempvar/{tempvar}")
    public List<Hello> helloListByTempvar(@PathVariable("tempvar") String tempvar) {
        return helloRepository.findByTempvar(tempvar);
    }

    @PostMapping(value = "/hellos/two")
    public void helloTwo() {
        helloService.insertTwo();
    }

    @GetMapping(value = "/hellos/getage/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        helloService.getAge(id);
    }
}
