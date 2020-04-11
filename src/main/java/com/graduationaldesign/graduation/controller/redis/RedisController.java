package com.graduationaldesign.graduation.controller.redis;

import com.graduationaldesign.graduation.aop.Day;
import com.graduationaldesign.graduation.controller.Api;
import com.graduationaldesign.graduation.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    final static String[] REDIS_KEY = new String[]{
            "login:student",
            "login:teacher",
            "login:admin",
            "update:report",
    };

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

    @RequestMapping(value = "/getAllNumber", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllNumber() {
        List<String> lstDay = Day.getAllValues();
        Map<String, Object> result = new HashMap<>();
        for (String keyPre : REDIS_KEY) {
            Map<String, Object> map = new HashMap<>();
            List list = new ArrayList();
            for (String suffix : lstDay) {
                String key = keyPre + ":" + suffix;
                String numberString = stringRedisTemplate.opsForValue().get(key);
                int number = numberString == null ? 0 : Integer.parseInt(numberString);
                map.put(suffix, number);
                list.add(number);
            }
            result.put(keyPre.replaceAll(":", "_"), list);
        }
        return ResponseStatus.success(result, this);
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