package com.lry.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liurenyi
 * @create 2019--12--28--15:01
 */
@RestController
public class RedisHandler {

    @Autowired
    private StringRedisTemplate str;

    @RequestMapping("/add")
    public void saveReiddis(){
        str.opsForValue().set("test","springboot整合redis");
    }

    @RequestMapping("/find")
    public String  getRedis(){
       return str.opsForValue().get("test");
    }
}
