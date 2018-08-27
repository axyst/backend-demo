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
    public void insertUser(String name, Integer age) {
        userMapper.insert(name, age);
    }

    @Transactional
    public void insertList(List<User> userList) {
        for (User user : userList) {
            String name = user.getName();
            Integer age = user.getAge();
            userMapper.insert(name, age);
        }
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
    public void updateUser(Long id, String name, Integer age) {
        userMapper.updateName(id, name);
        userMapper.updateAge(id, age);
    }

    @Transactional
    public void deleteUser(Long id) {
        userMapper.delete(id);
    }

    @Transactional
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
