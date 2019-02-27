package com.john.register.persistence;

import com.john.register.URL;

import java.util.Map;

/**
 * @Author: 张彦斌
 * @Date: 2019-02-27 11:14
 */
public class MapFilePersistence implements Persistence {

    @Override
    public void persist(Map<String, Map<URL, Class>> register) {

    }

    @Override
    public Map<String, Map<URL, Class>> loadMapRegister() {
        return null;
    }
}
