package com.max.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import java.util.Date;
import java.util.Random;

/**
 * Created by lenovo on 2017/5/4.
 */
public class RequestCacheCommand extends HystrixCommand<String> {
    private final int id;
    public RequestCacheCommand( int id) {
        super(HystrixCommandGroupKey.Factory.asKey("RequestCacheCommand"));
        this.id = id;
    }
    @Override
    protected String run() throws Exception {
        System.out.println(Thread.currentThread().getName() + " execute id=" + id);
        Random random = new Random();
        return "executed=" + random.nextInt();
    }
    //重写getCacheKey方法,实现区分不同请求的逻辑
    @Override
    protected String getCacheKey() {
        return String.valueOf(id);
    }

}
