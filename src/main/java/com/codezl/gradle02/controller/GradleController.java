package com.codezl.gradle02.controller;

import com.codezl.gradle02.annotation.UserCacheAnnotation;
import com.codezl.gradle02.config.RedisConfig;
import com.codezl.gradle02.domain.Goods;
import com.codezl.gradle02.service.PushOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: code-zl
 * @Date: 2022/04/07/14:40
 * @Description:
 */
@RestController
@RequestMapping("gradle")
public class GradleController {

    private static StringRedisTemplate stringRedisTemplate;

    static {
        stringRedisTemplate = new StringRedisTemplate();
    }

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Autowired
    PushOrderService pushOrderService;

    @GetMapping("01")
    public String gradle01(String pa) {
        Consumer<String> consumer = (params)->{if (params!=null) {
            System.out.print(params);
        }};
        consumer.accept(pa);
        return "你好"+pa;
    }

    @GetMapping("pushOrder")
    public void pushRedis(String orderNo) {
        Object orderInfo = new Object();
        //派单缓存
        redisTemplate.opsForValue().set(RedisConfig.CACHE_NAME_MINUTES_5+orderNo,orderInfo,5, TimeUnit.MINUTES);
    }

    @GetMapping("searchPush")
    public void searchPush(String orderNo) {
        //Object orderInfo = new Object();
        //派单缓存
        //redisTemplate.opsForValue().get(RedisConfig.CACHE_NAME_MINUTES_5+orderNo);
        String s = pushOrderService.searchPushOrder(orderNo,RedisConfig.CACHE_NAME_MINUTES_5+orderNo);
        Consumer<String> consumer = System.out::print;
        consumer.accept(s);
    }

    @PostMapping("cach2")
    public void cach2(@RequestBody Goods goods) {
        Goods s = pushOrderService.cach2(goods);
        Consumer<String> consumer = System.out::print;
        consumer.accept(s.toString());
    }

    @GetMapping("cacheEvict")
    public void cacheEvict() {
        String s = pushOrderService.cachEvict(2);
        System.out.print(s);
    }

    @GetMapping("befEvict")
    public void befEvict(int i,int id) {
        String s = pushOrderService.befEvict(i,id);
        System.out.print(s+"\n");
    }

    @GetMapping("allEvict")
    public void allEvict() {
        String s = pushOrderService.allEvict();
        System.out.print(s);
    }

    @GetMapping("ehCach")
    public void ehCach() {

    }

    /**
    * @Description: 不检查直接存入
    * @Param: [goods]
    * @return: void
    * @Author: code-zl
    * @Date: 2022/4/16
    */
    @GetMapping("cachePut")
    public void cachePut(int id) {
        Goods goods = pushOrderService.cachePut(id);
    }

    @GetMapping("caching")
    public void caching(@RequestParam(defaultValue = "1") int id) {
        Goods caching = pushOrderService.caching(id);
        System.out.print(caching);
    }

    @Cacheable(value = "cache1")
    @GetMapping("getCache1")
    public void getCache1(int id) {
        Goods goods = new Goods();
        goods.setId(id);
        goods.setName("getCache1");
    }

    @Cacheable(value = "cache2")
    @GetMapping("getCache2")
    public void getCache2(int id) {
        Goods goods = new Goods();
        goods.setId(id);
        goods.setName("getCache2");
    }

    @Cacheable(value = "cache3")
    @GetMapping("getCache3")
    public void getCache3(int id) {
        Goods goods = new Goods();
        goods.setId(id);
        goods.setName("getCache3");
    }

    @GetMapping("setCache1")
    public void setCache1(int id) {
        Goods goods = pushOrderService.cache1(id);
        System.out.print("setCache1"+goods);
    }

    @GetMapping("setCache3")
    public void setCache3(int id) {
        Goods goods = pushOrderService.cache3(id);
        System.out.print("setCache3"+goods);
    }

    @GetMapping("userCache")
    public void userCache(Integer id) {
        Goods goods = pushOrderService.userCache(id);
        System.out.print(goods);
    }
}
