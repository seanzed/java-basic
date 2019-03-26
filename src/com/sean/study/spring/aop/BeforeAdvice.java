package com.sean.study.spring.aop;

import java.lang.reflect.Method;

/**
 * @Description: 实现了 Advice 接口，是一个前置通知
 * @Author：sean.chen.dev@gmail.com
 * @Date： 2019-03-11 15:25
 * @Version: 1.0
 */
public class BeforeAdvice implements Advice {

    private Object bean;

    private MethodInvocation methodInvocation;

    public BeforeAdvice() {
    }

    public BeforeAdvice(Object bean, MethodInvocation methodInvocation) {
        this.bean = bean;
        this.methodInvocation = methodInvocation;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在目标方法执行前调用通知
        methodInvocation.invoke();
        return method.invoke(bean, args);
    }

}
