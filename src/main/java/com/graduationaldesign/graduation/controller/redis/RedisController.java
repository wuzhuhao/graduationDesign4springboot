package com.graduationaldesign.graduation.controller.redis;

import com.graduationaldesign.graduation.controller.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: wuzhuhao
 * @Date: 2020/2/5 2:56
 */
@RestController
@RequestMapping("/redis")
@Api(Pojo = "Redis", description = "redis控制层")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/get/{key}")
    public String getRedis(@PathVariable(name = "key") String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @PostMapping("/set/{key}/{value}")
    public String getRedis(@PathVariable(name = "key") String key,
                           @PathVariable(name = "value") String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return "SUCCESS";
    }


    @GetMapping("/postEntity")
    public String postEntity() {
//        User user = new User();
//        user.setId("1");
//        user.setName("pwl");
//        user.setAge("25");
        redisTemplate.opsForValue().set("1", null);
        return "SUCCESS";
    }

    @GetMapping("/getEntity/{key}")
    public Object getEntity(@PathVariable(name = "key") String key) {
        return redisTemplate.opsForValue().get(key);
    }
}