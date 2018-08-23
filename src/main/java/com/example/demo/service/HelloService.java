package com.example.demo.service;

import com.example.demo.domain.Hello;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.HelloException;
import com.example.demo.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class HelloService {
    @Autowired
    private HelloRepository helloRepository;

    @Transactional
    public void insertTwo() {
        Hello helloA = new Hello();
        helloA.setTempvar("B");
        helloA.setAge(18);
        helloRepository.save(helloA);
        Hello helloB = new Hello();
        helloB.setTempvar("C");
        helloB.setAge(21);
        helloRepository.save(helloB);
    }

    public void getAge(Integer id) throws Exception {
//        Optional<Hello> optional = helloRepository.findById(id);
//        Integer age = optional.orElseGet(Hello::new).getAge();
        Hello hello = helloRepository.findById(id).get();
        Integer age = hello.getAge();
        if (age > 22) {
            throw new HelloException(ResultEnum.ERROR_1);
        } else if (age < 20) {
            throw new HelloException(ResultEnum.ERROR_2);
        } else System.out.println(age);

    }

    public Optional<Hello> findOne(Integer id) {
        return helloRepository.findById(id);
    }
}
