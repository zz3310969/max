package org.max.hello;

import org.max.hello.mapper.UserMapper;
import org.max.hello.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private RedisService redisService;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public String greeting() throws IOException {
        //redisService.hasKey();
        System.out.print(userMapper.count("s"));
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

}
