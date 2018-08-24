package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MybatisTest {
    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private UserMapper userMapper;

    @Test
    @Rollback
//    public void findByName() throws Exception {
//        userMapper.insert("AAA", 20);
//        User u = userMapper.findByName("AAA").get(0);
//        Assert.assertEquals(20, u.getAge().intValue());
//    }
//    public void insertByMap() throws Exception {
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "CCC");
//        map.put("age", 40);
//        userMapper.insertByMap(map);
//        Assert.assertEquals(40, userMapper.findByName("CCC").get(0).getAge().intValue());
//    }
    public void testUserMapper() throws Exception {
        // insert一条数据，并select出来验证
        userMapper.insert("AAA", 20);
        User u = userMapper.findByName("AAA");
        Assert.assertEquals(20, u.getAge().intValue());
//        // cache validation
//        u = userMapper.findByName("AAA");
//        Assert.assertEquals(20, u.getAge().intValue());
        // update一条数据，并select出来验证
        u.setAge(30);
        userMapper.update(u);
        u = userMapper.findByName("AAA");
        Assert.assertEquals(30, u.getAge().intValue());
        // 删除这条数据，并select验证
        userMapper.delete(u.getID());
        u = userMapper.findByName("AAA");
        Assert.assertEquals(null, u);
        List<User> userList = userMapper.findAll();
        for(User user : userList) {
            Assert.assertNull(user.getID());
            Assert.assertNotEquals(null, user.getName());
        }
    }


}
