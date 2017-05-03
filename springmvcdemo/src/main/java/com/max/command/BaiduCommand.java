package com.max.command;

import com.max.BaiduService;
import com.max.TokenService;
import com.netflix.hystrix.*;

/**
 * Created by lenovo on 2017/4/24.
 */
public class BaiduCommand extends HystrixCommand<String> {
    private String name;
    private BaiduService service;
    public BaiduCommand(BaiduService service) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("TokenGroup"))
                /* 配置依赖超时时间,500毫秒*/
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationThreadTimeoutInMilliseconds(500)));
        this.name = name;
        this.service = service;
    }

    protected String getFallback() {
        return new FallbackViaNetwork(1).execute();
    }


    protected String run() throws Exception {
        return service.http();
    }

    private static class FallbackViaNetwork extends HystrixCommand<String> {
        private final int id;
        public FallbackViaNetwork(int id) {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceX"))
                    .andCommandKey(HystrixCommandKey.Factory.asKey("GetValueFallbackCommand"))
                    // 使用不同的线程池做隔离，防止上层线程池跑满，影响降级逻辑.
                    .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("RemoteServiceXFallback")));
            this.id = id;
        }
        @Override
        protected String run() {
            return  "sss";
        }

        @Override
        protected String getFallback() {
            return null;
        }
    }


}
