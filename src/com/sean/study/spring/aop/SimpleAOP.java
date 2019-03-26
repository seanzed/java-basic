package com.sean.study.spring.aop;

import java.lang.reflect.Proxy;

/**
 * @Description: 生成代理类
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-11 15:31
 * @Version: 1.0
 */
public class SimpleAOP {

    public static Object getProxy(Object bean, Advice advice) {
        return Proxy.newProxyInstance(SimpleAOP.class.getClassLoader(),
            bean.getClass().getInterfaces(), advice);
    }
}
