package com.max;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by Zhenglt on 17/4/20.
 */
public class HelloWorldCommand  extends HystrixCommand<String> {

    private HelloService helloService;
    public HelloWorldCommand(HelloService helloService) {
        //最少配置:指定命令组名(CommandGroup)
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.helloService = helloService;
    }

    protected String run() throws Exception {
        return helloService.hello();
    }
}
