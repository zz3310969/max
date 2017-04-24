package com.max;

/**
 * Created by lenovo on 2017/4/21.
 */
import com.max.command.HelloWorldCommand;
import com.max.command.TokenCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

    @Autowired
    private HelloService helloService;
    @Autowired
    private TokenService tokenService;
    @ResponseBody
    @RequestMapping("/greeting")
    public String greeting() {
        HelloWorldCommand helloWorldCommand = new HelloWorldCommand(helloService);
        //使用execute()同步调用代码,效果等同于:helloWorldCommand.queue().get();
        String result = helloWorldCommand.execute();

        TokenCommand tokenCommand = new TokenCommand(tokenService,"abc_plct");
        System.out.println(tokenCommand.execute());
        return "greeting";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
