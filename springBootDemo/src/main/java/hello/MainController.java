package hello;

import hello.mapper.UserMapper;
import hello.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MainController {

    @Autowired
    private RedisService redisService;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public String greeting() throws IOException {
        redisService.hasKey();
        System.out.print(userMapper.count("s"));
        return "index";
    }

}
