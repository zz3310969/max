package com.max;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Hc on 17/4/20.
 */
public class App {


    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-mvc.xml");
        HelloService helloService = context.getBean("helloService",HelloService.class);

        HelloWorldCommand helloWorldCommand = new HelloWorldCommand(helloService);
        //使用execute()同步调用代码,效果等同于:helloWorldCommand.queue().get();
        String result = helloWorldCommand.execute();

        System.out.println(result);

    }


}
