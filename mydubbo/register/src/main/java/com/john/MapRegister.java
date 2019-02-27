package com.john;

import com.john.register.URL;
import com.john.register.persistence.MapRedisPersistence;
import com.john.register.persistence.Persistence;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 张彦斌
 * @Date: 2019-02-26 15:32
 */
public class MapRegister {

    private static Map<String, Map<URL,Class>> REGISTER = new ConcurrentHashMap(8);

    public static void registe(String interfaceName,URL url,Class clazz){
        Map<URL, Class> map = new HashMap<>();
        map.put(url, clazz);
        REGISTER.put(interfaceName, map);

        Persistence persistence = new MapRedisPersistence();
        persistence.persist(REGISTER);
    }

    public static Class get(String interfaceName,URL url){
        if (REGISTER.size() == 0) {
            Persistence persistence = new MapRedisPersistence();
            REGISTER = persistence.loadMapRegister();
        }
        return REGISTER.get(interfaceName).get(url);

    }

    public static URL getURL(String interfaceName) {
        if (REGISTER.size() == 0) {
            Persistence persistence = new MapRedisPersistence();
            REGISTER = persistence.loadMapRegister();
        }
        Iterator<URL> iterator = REGISTER.get(interfaceName).keySet().iterator();
        return iterator.next();
    }
}
