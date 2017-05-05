package com.max.command;

import com.max.HelloService;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * Created by Zhenglt on 17/4/20.
 */
public class HelloWorldCommand  extends HystrixCommand<String> {

    private HelloService helloService;
    public HelloWorldCommand(HelloService helloService) {
        //最少配置:指定命令组名(CommandGroup)
        //super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withRequestCacheEnabled(false)));
        this.helloService = helloService;
    }



    protected String run() throws Exception {
        return helloService.hello();
    }
}
