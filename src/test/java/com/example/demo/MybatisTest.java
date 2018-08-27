package com.example.demo;

import com.example.demo.aspect.HttpAspect;
import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MybatisTest {
    @Autowired
    private UserService userService;
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Test
    @Rollback
    public void testUserMapper() throws Exception {
        userService.insertUser("AAA", 20);
        User u = userService.findByName("AAA").get(0);
        Long id = u.getId();
        logger.info(id + u.getName() + u.getAge());

        Assert.assertEquals(20, u.getAge().intValue());

        userService.updateUser(id, "BBB", 21);
        User u2 = userService.findById(id);
        logger.info(u2.getId() + u2.getName() + u2.getAge());
        u2 = new User("CCC", 22);
        List<User> list = new ArrayList<User>();
        list.add(u2);
        userService.insertList(list);
        u = userService.findByName("CCC").get(0);
        logger.info(u.getId() + u.getName() + u.getAge());

        Assert.assertEquals(22, u.getAge().intValue());

        List<User> list2 = userService.findAll();
        for (User user : list2) {
            logger.info(user.getId() + user.getName() + user.getAge());
        }
        id = userService.findByName("CCC").get(0).getId();
        userService.deleteUser(id);
        u = userService.findById(id);

        Assert.assertEquals(null, u);
    }


}
