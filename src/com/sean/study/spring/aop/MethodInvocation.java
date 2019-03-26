package com.sean.study.spring.aop;

import java.lang.reflect.InvocationHandler;

/**
 * @Description: 实现类包含了切面逻辑
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-11 15:21
 * @Version: 1.0
 */
public interface MethodInvocation {

    void invoke();
}
