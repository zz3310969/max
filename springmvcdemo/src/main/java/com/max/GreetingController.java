package com.max;

/**
 * Created by lenovo on 2017/4/21.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

    @Autowired
    private HelloService helloService;
    @ResponseBody
    @RequestMapping("/greeting")
    public String greeting() {
        HelloWorldCommand helloWorldCommand = new HelloWorldCommand(helloService);
        //使用execute()同步调用代码,效果等同于:helloWorldCommand.queue().get();
        String result = helloWorldCommand.execute();
        return "greeting";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
