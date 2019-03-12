package com.example.authserver.config;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description redis 分布式锁测试
 * @Author 曾孝
 * @Date 2019/3/12 下午4:23
 */
@Component
public class RedissionLockDemo {

    @Autowired
    private RedissonClient redissonClient;

    public void testDemo() {
        RLock lock = redissonClient.getLock("RedissionLockDemo");
        lock.tryLock();
    }

}
