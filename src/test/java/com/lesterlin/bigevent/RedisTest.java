package com.lesterlin.bigevent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

@SpringBootTest // 若在測試類添加這個註解，單元測試在執行方法之前會先初始化spring容器
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testSet(){
        // 在redis中儲存一個鍵值對 StringRedisTemplate
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();

        operations.set("username","L");
        operations.set("id","1",15, TimeUnit.SECONDS);
    }

    @Test
    public void testGet(){
        // 從redis中獲取一個鍵值對
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();

        System.out.println(operations.get("username"));
    }
}
