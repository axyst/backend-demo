package com.example.demo;

import com.example.demo.domain.Hello;
import com.example.demo.service.HelloService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloServiceTest {

//    @Autowired
//    private HelloService helloService;
//
//    @Test
//    public void findOneTest() {
//        Optional<Hello> hello = helloService.findOne(15);
//        Assert.assertEquals(Integer.valueOf(21), hello.get().getAge());
//    }
    @Autowired
    private MockMvc mvc;
    @Test
    public void helloList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hellos")).andExpect(MockMvcResultMatchers.status().isOk());
        //.andExpect(MockMvcResultMatchers.content().string("abc"))
    }
}
