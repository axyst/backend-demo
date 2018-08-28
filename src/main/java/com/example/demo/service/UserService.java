package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public Integer insertUser(String name, Integer age) {
        return userMapper.insert(name, age);
    }

    @Transactional
    public Integer insertList(List<User> userList) {
        Integer res = 0;
        for (User user : userList) {
            String name = user.getName();
            Integer age = user.getAge();
            res += userMapper.insert(name, age);
        }
        return res;
    }

    @Transactional
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    @Transactional
    public List<User> findByName(String name) {
        return userMapper.findByNameList(name);
    }

    @Transactional
    public Integer updateUser(Long id, String name, Integer age) {
        Integer res = 0;
        res += userMapper.updateName(id, name);
        res += userMapper.updateAge(id, age);
        return res;
    }

    @Transactional
    public Integer deleteUser(Long id) {
        return userMapper.delete(id);
    }

    @Transactional
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
