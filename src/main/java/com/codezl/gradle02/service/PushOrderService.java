package com.codezl.gradle02.service;

import com.alibaba.fastjson.JSONObject;
import com.codezl.gradle02.annotation.UserCacheAnnotation;
import com.codezl.gradle02.config.RedisConfig;
import com.codezl.gradle02.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: code-zl
 * @Date: 2022/04/14/16:39
 * @Description:
 */
@Service
public class PushOrderService {
    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    /**
    * @Description: 获取缓存，如无则将返回值设置为缓存，类似set集合的属性
    * @Param: [orderNo, cacheName]
    * @return: java.lang.String
    * @Author: code-zl
    * @Date: 2022/4/14
    */
    //适合获取缓存
    @Cacheable(value = "cache1",key = "#p1",unless = "#result == null")
    public String searchPushOrder(String orderNo,String cacheName) {
        JSONObject orderInfo = new JSONObject();
        orderInfo.put("driverId",1);
        orderInfo.put("price",100);
        String orderInfo1=orderNo+":info\n";
        //redisTemplate.opsForValue().set(cacheName,orderInfo1);
        return orderInfo1;
    }

    @Cacheable(value = "cache1",key = "'RedisConfig.CACHE_NAME_MINUTES_5'+#p1")
    public String searchPushOrder1(String orderNo,String cacheName) {
        JSONObject orderInfo = new JSONObject();
        orderInfo.put("driverId",1);
        orderInfo.put("price",100);
        String orderInfo1=orderNo+":info";
        redisTemplate.opsForValue().set(RedisConfig.CACHE_NAME_MINUTES_5+orderNo,orderInfo1);
        return null;
    }

    /**
    * @Description: 缓存
    * @Param: [goods]
    * @return: com.codezl.gradle02.domain.Goods
    * @Author: code-zl
    * @Date: 2022/4/16
    */
    @Cacheable(value = "cache2",key = "#p0.id",condition = "#p0.id%2==0")
    public Goods cach2(Goods goods) {
        String name = goods.getName();
        if (name==null) {
            throw new RuntimeException(this.getClass().getName()+"空值");
        }
        //redisTemplate.opsForValue().set(goods.getName(),goods.getId()+"1");
        return goods;
    }

    /**
    * @Description: 清除缓存
    * @Param: [id]
    * @return: java.lang.String
    * @Author: code-zl
    * @Date: 2022/4/16
    */
    @CacheEvict(value = "cache2",key = "#p0")
    public String cachEvict(Integer id) {
        return "success:"+id;
    }

    /**
    * @Description: 方法执行之前清除
    * @Param: [i, id]
    * @return: java.lang.String
    * @Author: code-zl
    * @Date: 2022/4/16
    */
    @CacheEvict(value = "cache2",key = "#p1",beforeInvocation = true)
    public String befEvict(int i,int id) {
        if (i==1) {
            throw new NullPointerException("抛出异常前清除缓存");
        }
        return "success";
    }

    /**
    * @Description: 全部清除
    * @Param: []
    * @return: java.lang.String
    * @Author: code-zl
    * @Date: 2022/4/16
    */
    @CacheEvict(value = "cache2",allEntries = true)
    public String allEvict() {
        return "success";
    }

    /**
    * @Description: 直接将返回值存入cache，每次都执行方法，类似hashMap的put,不检查是否存在相同key的值，有则覆盖
    * @Param: [goods]
    * @return: com.codezl.gradle02.domain.Goods
    * @Author: code-zl
    * @Date: 2022/4/16
    */
    //适合用来覆盖缓存，例如重新登录
    @CachePut(value = "cache2",key = "#p0")
    public Goods cachePut(Integer id) {
        Goods goods = new Goods();
        goods.setId(id);
        goods.setName("hello");
        return goods;
    }

    /**
    * @Description: @Caching注解可以让我们在一个方法或者类上同时指定多个Spring Cache相关的注解。其拥有三个属性：
     * cacheable、put和evict，分别用于指定@Cacheable、@CachePut和@CacheEvict。
    * @Param:
    * @return:
    * @Author: code-zl
    * @Date: 2022/4/16
    */
    @Caching(cacheable = @Cacheable("cache2"),
            evict = @CacheEvict(value = "cache3"),put = @CachePut("cache1"))
    public Goods caching(Integer id) {
        System.out.print("\n执行caching\n");
        Goods goods = new Goods();
        goods.setId(id);
        goods.setName("caching");
        return goods;
    }

    @Cacheable(value = "cache1")
    public Goods cache1(int id) {
        System.out.print("\n执行cache1\n");
        Goods goods = new Goods();
        goods.setId(id);
        goods.setName("cache1");
        return goods;
    }

    @Cacheable(value = "cache3")
    public Goods cache3(int id) {
        System.out.print("\n执行cache3\n");
        Goods goods = new Goods();
        goods.setId(id);
        goods.setName("cache1");
        return goods;
    }

    @UserCacheAnnotation
    public Goods userCache(Integer id) {
        Goods goods = new Goods();
        goods.setId(id);
        goods.setName("userCache");
        return goods;
    }

}
