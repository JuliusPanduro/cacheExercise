package com.example.demo.services;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Julius Panduro
 */

public class Cache {
    private Map<String, String> cache = new HashMap<>();
    private Map<String, Long> timer = new HashMap<>();
    private long TTL;

    public Cache(long ttlValue){
    setTTL(ttlValue);

    }

    public String getCache(String key) {
        if (isExpired(key)) {
            deleteCache(key);
            return null;
        }
        return this.cache.get(key);
    }

    public boolean isExpired(String key) {
        return (System.nanoTime() - timer.get(key) > this.TTL);
    }

    public void setCache(String key, String value) {
        this.cache.put(key, value);
        this.timer.put(key, System.nanoTime());
    }

    public boolean hasCache(String key) {
        if (this.cache.get(key)==null){
            return false;
        } else {
            return true;
        }
    }

    public void deleteCache(String key) {
        this.cache.remove(key);
        this.timer.remove(key);
    }

    public void setTTL(long ttlValue) {
        TimeUnit ttlUnit = TimeUnit.SECONDS;
        this.TTL = ttlUnit.toNanos(ttlValue);

    }
}
