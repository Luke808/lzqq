package com.accenture.smsf.sample.service;

import com.accenture.smsf.framework.boot.stereotype.Component;
import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

@Component
public class CacheKeyGenerator implements KeyGenerator {

    private static final String SAMPLE_DATA = "sample-data";
    @Override
    public Object generate(Object target, Method method, Object... params) {
        return SAMPLE_DATA;
    }
}
