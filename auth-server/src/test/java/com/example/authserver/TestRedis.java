package com.example.authserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author:ZengXiao
 * @Description:
 * @Date: Create in 19:27 2019/3/7
 * @Modified By:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRedis {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testRedis() {
        String key = "user_token:";
        redisTemplate.opsForValue().set(key,"aaaaa");
    }

}
