package com.john.register.persistence;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.john.register.URL;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: 张彦斌
 * @Date: 2019-02-27 11:14
 */
public class MapRedisPersistence implements Persistence {

    JedisPool pool;

    public MapRedisPersistence() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10);
        pool = new JedisPool(jedisPoolConfig, "localhost", 6379);
    }

    @Override
    public void persist(Map<String, Map<URL, Class>> register) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            JSONObject jsonObject = new JSONObject();
            jsonObject.putAll(register);
            jedis.set("mapRegister", jsonObject.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //还回pool中
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public Map<String, Map<URL, Class>> loadMapRegister() {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            String jsonStr = jedis.get("mapRegister");
            Map<String, Map<JSONObject, String>> map = (Map<String, Map<JSONObject, String>>) JSON.parse(jsonStr);
            Map<String, Map<URL, Class>> result = new HashMap<>();
            map.forEach((interfaceName,m) -> {
                m.forEach((url,clazz) -> {
                    HashMap<URL, Class> serviceInfo = new HashMap<>();
                    try {
                        serviceInfo.put(JSON.toJavaObject(url,URL.class), Class.forName(clazz));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    result.put(interfaceName, serviceInfo);
                });
            });
            return result;
        } finally {
            //还回pool中
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
