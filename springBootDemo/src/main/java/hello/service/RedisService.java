package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/5/27.
 */
@Service
public class RedisService {

    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RedisService(StringRedisTemplate stringRedisTemplate){
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public Boolean hasKey(){
        return  stringRedisTemplate.hasKey("sss");
    }

}
